package com.controller;

import com.models.Telefone;
import com.repository.TelefoneRepository;

import jakarta.validation.Valid;

import com.config.TelefoneService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telefone")
public class TelefoneController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    TelefoneService telefoneService;


    @GetMapping("{id}")
    public ResponseEntity<Telefone> show(@PathVariable Long id){
        log.info("detalhando telefone com id" + id);
        return ResponseEntity.ok(getTelefone(id));
    }

    @PostMapping()
    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone, BindingResult result){
        log.info("cadastrando telefone" + telefone);
        telefoneRepository.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    @PutMapping("{id}")
    public ResponseEntity<Telefone> update(@PathVariable Long id, @RequestBody @Valid Telefone telefone){
        log.info("atualizando telefone" + id);
        
        getTelefone(id);
        
        telefone.setId(id);
        telefoneRepository.save(telefone);

        return ResponseEntity.ok(telefone);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Telefone> destroy(@PathVariable Long id){
        log.info("apagando telefone" + id);
        var telefone = getTelefone(id);
        telefoneRepository.save(telefone);
        return ResponseEntity.noContent().build(); 
    }

}
