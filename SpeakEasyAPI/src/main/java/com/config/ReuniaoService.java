package com.config;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.models.Reuniao;
import com.repository.ReuniaoRepository;

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
