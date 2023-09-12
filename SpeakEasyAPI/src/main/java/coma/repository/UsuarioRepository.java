package coma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import coma.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
 
    Usuario findByEmail(String busca);

}
