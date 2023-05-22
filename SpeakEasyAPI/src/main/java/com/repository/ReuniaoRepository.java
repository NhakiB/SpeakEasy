package com.repository;
import java.time.ZonedDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import com.models.Reuniao;

public interface ReuniaoRepository extends JpaRepository<Reuniao, Long>{
 
    Reuniao findByData(ZonedDateTime busca);

}
