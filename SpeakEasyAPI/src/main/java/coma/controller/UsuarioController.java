package coma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import coma.service.UsuarioService;
import coma.models.Usuario;
import coma.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;
    /**
     * Obtém todos os usuários.
     *
     * @return Lista de usuários
     */
    @GetMapping
    @Cacheable(value = "usuariosCache")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    /**
     * Obtém um usuário pelo ID.
     *
     * @param id ID do usuário
     * @return ResponseEntity contendo o usuário ou NOT_FOUND se não encontrado
     */
    @GetMapping("/{id}")
    @Cacheable(value = "usuariosCache", key = "#id")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String id) {
        log.info("Detalhando usuário com id: {}", id);

        return usuarioRepository.findById(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /**
     * Cria um novo usuário.
     *
     * @param usuario Novo usuário a ser criado
     * @return ResponseEntity contendo o usuário recém-criado
     */
    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        log.info("Cadastrando usuário: {}", usuario);

        usuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
    /**
     * Atualiza um usuário existente pelo ID.
     *
     * @param id      ID do usuário a ser atualizado
     * @param usuario Usuário com dados atualizados
     * @return ResponseEntity contendo o usuário atualizado ou NOT_FOUND se não encontrado
     */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        log.info("Atualizando usuário com id: {}", id);

        return usuarioRepository.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setNome(usuario.getNome());
                    existingUsuario.setEmail(usuario.getEmail());
                    existingUsuario.setSenha(usuario.getSenha());
                    return new ResponseEntity<>(usuarioRepository.save(existingUsuario), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /**
     * Exclui um usuário pelo ID.
     *
     * @param id ID do usuário a ser excluído
     * @return ResponseEntity sem conteúdo se excluído com sucesso ou NOT_FOUND se não encontrado
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") String id) {
        log.info("Apagando usuário com id: {}", id);

        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
