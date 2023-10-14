package coma.repository;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import coma.models.Reuniao;
/**
 * Repositório para operações relacionadas as reuniões no banco de dados.
 */
public interface ReuniaoRepository extends JpaRepository<Reuniao, Long>{
    /**
     * função para encontrar uma reunião pela data no banco de dados..
     */
    Reuniao findByData(Date busca);

}
