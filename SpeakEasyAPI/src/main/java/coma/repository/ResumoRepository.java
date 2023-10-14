package coma.repository;

import coma.models.Resumo;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositório para operações relacionadas aos resumos no banco de dados.
 */
public interface ResumoRepository extends JpaRepository<Resumo, Long> {
    /**
     * função para encontrar um resumo pelo conteudo no banco de dados.
     */
    Resumo findBytextoResumido(String textoResumido);

}