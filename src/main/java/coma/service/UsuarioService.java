package coma.service;

import coma.models.Usuario;
import coma.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * Serviço responsável por lógica de negócios relacionada aos usuários.
 */
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    /**
     * Obtém um usuário pelo seu ID.
     *
     * @param id ID do usuário a ser obtido
     * @return O usuário com o ID especificado
     * @throws Exception Se o usuário não for encontrado
     */
    @Cacheable(value = "usuarioCache", key = "id")
    @Transactional(readOnly = true)
    public Usuario obterUsuario(Long id) throws Exception {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new Exception("Usuario não encontrado com o id: " + id);
        }
    }



    @Async
    public boolean login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email) ;
        if (usuario == null) {
            return false;
        }
        else {

            return passwordEncoder.matches(password, usuario.getSenha());
        }

    }
}
