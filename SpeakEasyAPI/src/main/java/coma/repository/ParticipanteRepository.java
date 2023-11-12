package coma.repository;

import coma.models.Participante;
import coma.models.Reuniao;
import coma.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repositório para operações relacionadas aos participantes no banco de dados.
 */
public interface ParticipanteRepository extends JpaRepository<Participante, String>{

    /**
     * função para encontrar um participante pelo email no banco de dados..
     */
    Usuario findByEmail( String email);

}
