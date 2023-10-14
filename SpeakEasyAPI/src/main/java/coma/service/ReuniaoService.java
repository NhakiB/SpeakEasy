package coma.service;

import java.util.Date;

import coma.models.Reuniao;
import coma.repository.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Serviço responsável por lógica de negócios relacionada as reuniões.
 */
@Service
public class ReuniaoService {

    private final ReuniaoRepository reuniaoRepository;

    @Autowired
    public ReuniaoService(ReuniaoRepository reuniaoRepository) {
        this.reuniaoRepository = reuniaoRepository;
    }
    /**
     * Obtém um usuário pelo seu ID.
     *
     * @param id ID da reunião a ser obtido
     * @return A reunião com o ID especificado
     * @throws Exception Se a reunião não for encontrada
     */
    @Cacheable(value = "reuniaoCache", key = "id")
    @Transactional(readOnly = true)
    public Reuniao obterReuniaoPorId(Long id) throws Exception {
        return reuniaoRepository.findById(id)
                .orElseThrow(() -> new Exception("Reunião não encontrada com o ID: " + id));
    }

    @Async
    @Transactional

    public boolean reuniaoValida(Date data) {
        Reuniao reuniao = reuniaoRepository.findByData(data) ;
        if (reuniao == null) {
            return false;
        }
        else if (reuniao.getData() == data){
            return true;
        }
        else{
            return false;
        }
    }

}
