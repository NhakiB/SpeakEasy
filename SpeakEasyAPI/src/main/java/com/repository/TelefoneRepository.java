package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
 
    Telefone findByNrTelefone(int busca);

}
