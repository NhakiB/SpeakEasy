package coma.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import coma.models.Telefone;
/**
 * Repositório para operações relacionadas aos telefones no banco de dados.
 */
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
    /**
     * função para encontrar um telefone pelo número no banco de dados..
     */
    Telefone findByNrTelefone(int nrTelefone);

}
