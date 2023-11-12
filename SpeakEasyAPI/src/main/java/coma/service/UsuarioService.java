package coma.service;

import coma.models.Usuario;
import coma.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * Serviço responsável por lógica de negócios relacionada aos usuários.
 */
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;


    /**
     * Obtém um usuário pelo seu ID.
     *
     * @param id ID do usuário a ser obtido
     * @return O usuário com o ID especificado
     * @throws Exception Se o usuário não for encontrado
     */
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario obterUsuario(String id) throws Exception {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new Exception("Usuario não encontrado com o id: " + id);
        }
    }





}
