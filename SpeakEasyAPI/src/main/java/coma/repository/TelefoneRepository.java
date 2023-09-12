package coma.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import coma.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
 
    Telefone findByNrTelefone(int busca);

}
