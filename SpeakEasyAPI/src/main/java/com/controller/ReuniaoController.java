package com.controller;

import com.config.ReuniaoService;
import com.models.Reuniao;
import com.repository.ReuniaoRepository;

import jakarta.validation.Valid;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController {

    Logger log = LoggerFactory.getLogger(ReuniaoController.class);

    @Autowired
    ReuniaoRepository reuniaoRepository;

    @Autowired
    ReuniaoService reuniaoService;

    @GetMapping()
    public List<Reuniao> show(){
        return reuniaoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Reuniao> show(@PathVariable Long id) {
        log.info("detalhando reunião com id" + id);
        return ResponseEntity.ok(getReuniao(id));
    }

    private Object getReuniao(Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Reuniao> create(@RequestBody @Valid Reuniao reuniao, BindingResult result) {
        log.info("cadastrando reunião" + reuniao);
        reuniaoRepository.save(reuniao);
        return ResponseEntity.status(HttpStatus.CREATED).body(reuniao);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reuniao> update(@PathVariable Long id, @RequestBody @Valid Reuniao reuniao){
        log.info("atualizando reunião" + id);
        
        getReuniao(id);
        
        reuniao.setId(id);
        reuniaoRepository.save(reuniao);

        return ResponseEntity.ok(reuniao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Reuniao> destroy(@PathVariable Long id){
        log.info("apagando reunião" + id);
        var reuniao = getReuniao(id);
        reuniaoRepository.save(reuniao);
        return ResponseEntity.noContent().build(); 
    }

}
