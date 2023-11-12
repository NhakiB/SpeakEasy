package coma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import coma.models.Usuario;
/**
 * Repositório para operações relacionadas aos usuários no banco de dados.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

    /**
     * função para encontrar um usuário pelo email no banco de dados..
     */
    Usuario findByEmail( String email);

}
