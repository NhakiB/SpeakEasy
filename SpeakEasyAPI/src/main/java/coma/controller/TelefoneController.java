//package coma.controller;
//
//import coma.models.Telefone;
//import coma.repository.TelefoneRepository;
//
//import jakarta.validation.Valid;
//
//import coma.config.TelefoneService;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/telefone")
//public class TelefoneController {
//    Logger log = LoggerFactory.getLogger(TelefoneController.class);
//
//    @Autowired
//    TelefoneRepository telefoneRepository;
//
//    @Autowired
//    TelefoneService telefoneService;
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getTelefone(@PathVariable Long id) {
//        // Lógica para obter o telefone com o ID especificado
//        Telefone telefone = telefoneRepository.findById(id).orElse(null);
//
//        if (telefone != null) {
//            return ResponseEntity.ok(telefone);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//
//    @GetMapping("{id}")
//    public ResponseEntity<Telefone> show(@PathVariable Long id){
//        log.info("detalhando telefone com id" + id);
//        return ResponseEntity.ok(getTelefone(id));
//    }
//
//
//
//    @PostMapping()
//    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone, BindingResult result){
//        log.info("cadastrando telefone" + telefone);
//        telefoneRepository.save(telefone);
//        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<Telefone> update(@PathVariable Long id, @RequestBody @Valid Telefone telefone){
//        log.info("atualizando telefone" + id);
//
//        getTelefone(id);
//
//        telefone.setId(id);
//        telefoneRepository.save(telefone);
//
//        return ResponseEntity.ok(telefone);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Telefone> destroy(@PathVariable Long id){
//        log.info("apagando telefone" + id);
//        var telefone = getTelefone(id);
//        telefoneRepository.save(telefone);
//        return ResponseEntity.noContent().build();
//    }
//
//}
package coma.controller;

import java.util.List;

import coma.config.TelefoneService;
import coma.exceptions.RestNotFoundException;
import coma.models.Telefone;
import coma.repository.TelefoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/telefone")
public class TelefoneController {

    Logger log = LoggerFactory.getLogger(TelefoneController.class);

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    TelefoneService telefoneService;

    @GetMapping()
    public List<Telefone> show(){
        return telefoneRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Telefone> show(@PathVariable Long id){
        log.info("detalhando Telefone com id" + id);
        return ResponseEntity.ok(getTelefone(id));
    }

    @PostMapping()
    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone, BindingResult result){
        log.info("cadastrando usuario" + telefone);
        telefoneRepository.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    @PutMapping("{id}/telefone")
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



    private Telefone getTelefone(Long id) {
        var telefone = telefoneRepository.findById(id).orElseThrow(() -> new RestNotFoundException("telefone não encontrado"));
        return telefone;
    }



}
