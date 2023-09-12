package coma.controller;

import java.util.List;

import coma.config.ReuniaoService;
import coma.exceptions.RestNotFoundException;
import coma.models.Reuniao;
import coma.repository.ReuniaoRepository;
import coma.repository.UsuarioRepository;
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

import coma.config.UsuarioService;
import coma.models.Usuario;

@RestController
@RequestMapping("/api/reuniao")
public class ReuniaoController {

    Logger log = LoggerFactory.getLogger(ReuniaoController.class);

    @Autowired
    ReuniaoRepository reuniaoRepository;

    @Autowired
    ReuniaoService usuarioService;

    @GetMapping()
    public List<Reuniao> show(){
        return reuniaoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Reuniao> show(@PathVariable Long id){
        log.info("detalhando reuniao com id" + id);
        return ResponseEntity.ok(getReuniao(id));
    }

    @PostMapping()
    public ResponseEntity<Reuniao> create(@RequestBody @Valid Reuniao reuniao, BindingResult result){
        log.info("cadastrando reuniao" + reuniao);
        reuniaoRepository.save(reuniao);
        return ResponseEntity.status(HttpStatus.CREATED).body(reuniao);
    }

    @PutMapping("{id}/reuniao")
    public ResponseEntity<Reuniao> update(@PathVariable Long id, @RequestBody @Valid Reuniao reuniao){
        log.info("atualizando reuniao" + id);

        getReuniao(id);

        reuniao.setId(id);
        reuniaoRepository.save(reuniao);

        return ResponseEntity.ok(reuniao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Reuniao> destroy(@PathVariable Long id){
        log.info("apagando reuniao" + id);
        var reuniao = getReuniao(id);
        reuniao.setAtivo(false);
        reuniaoRepository.save(reuniao);
        return ResponseEntity.noContent().build();
    }



    private Reuniao getReuniao(Long id) {
        var reuniao = reuniaoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("reuniao não encontrada"));
        return reuniao;
    }



}
