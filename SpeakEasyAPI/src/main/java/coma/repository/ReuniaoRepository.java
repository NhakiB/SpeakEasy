package coma.repository;

import coma.models.Reuniao;
import coma.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repositório para operações relacionadas aos usuários no banco de dados.
 */
public interface ReuniaoRepository extends JpaRepository<Reuniao, String> {
    /**
     * função para encontrar uma reunião pelo titulo no banco de dados..
     */
    Usuario findByTitulo(String titulo);
}
