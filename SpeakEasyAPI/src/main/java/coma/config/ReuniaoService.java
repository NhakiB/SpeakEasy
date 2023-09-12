package coma.config;

import java.time.ZonedDateTime;

import coma.models.Reuniao;
import coma.repository.ReuniaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ReuniaoService {

    private ReuniaoRepository reuniaoRepository;

    public boolean reuniaoValida(ZonedDateTime data) {
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
