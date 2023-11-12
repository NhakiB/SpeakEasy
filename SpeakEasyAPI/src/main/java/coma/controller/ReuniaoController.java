package coma.controller;

import coma.models.Participante;
import coma.models.Reuniao;
import coma.repository.ParticipanteRepository;
import coma.repository.ReuniaoRepository;
import coma.service.ReuniaoService;
import coma.service.UsuarioService;
import coma.models.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/reuniao")
public class ReuniaoController {

    private final Logger log = LoggerFactory.getLogger(ReuniaoController.class);

    private final ReuniaoRepository reuniaoRepository;
    private final ReuniaoService reuniaoService;
    private final UsuarioService usuarioService;
    private final ParticipanteRepository participanteRepository;

    @Autowired
    public ReuniaoController(ReuniaoRepository reuniaoRepository, ReuniaoService reuniaoService,
                             UsuarioService usuarioService, ParticipanteRepository participanteRepository) {
        this.reuniaoRepository = reuniaoRepository;
        this.reuniaoService = reuniaoService;
        this.usuarioService = usuarioService;
        this.participanteRepository = participanteRepository;
    }

    @GetMapping
    public List<Reuniao> getAllReunioes() {
        return reuniaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reuniao> getReuniaoById(@PathVariable String id) {
        log.info("Detalhando reunião com id: {}", id);

        return reuniaoRepository.findById(id)
                .map(reuniao -> new ResponseEntity<>(reuniao, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Reuniao> createReuniao(@Valid @RequestBody Reuniao reuniao) {
        log.info("Cadastrando reunião: {}", reuniao);

        reuniao = reuniaoRepository.save(reuniao);
        return new ResponseEntity<>(reuniao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reuniao> updateReuniao(@PathVariable("id") String id, @RequestBody Reuniao reuniao) {
        log.info("Atualizando reunião com id: {}", id);

        return reuniaoRepository.findById(id)
                .map(existingReuniao -> {
                    existingReuniao.setTitulo(reuniao.getTitulo());
                    existingReuniao.setDescricao(reuniao.getDescricao());
                    existingReuniao.setData(reuniao.getData());
                    return new ResponseEntity<>(reuniaoRepository.save(existingReuniao), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReuniao(@PathVariable("id") String id) {
        log.info("Apagando reunião com id: {}", id);

        return reuniaoRepository.findById(id)
                .map(reuniao -> {
                    reuniaoRepository.delete(reuniao);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/{reuniaoId}/participantes/{usuarioId}")
//    public ResponseEntity<String> adicionarParticipante(@PathVariable String reuniaoId, @PathVariable String usuarioId) {
//        Reuniao reuniao = reuniaoService.getReuniaoById(reuniaoId);
//        Usuario usuario = usuarioService.obterUsuario(usuarioId);
//
//        Participante participante = new Participante();
//        participante.setReuniao(reuniao);
//        participante.setUsuario(usuario);
//
//        participanteRepository.save(participante);
//
//        return ResponseEntity.ok("Participante adicionado com sucesso.");
//    }
//
//    @GetMapping("/{reuniaoId}/participantes")
//    public ResponseEntity<List<Participante>> listarParticipantes(@PathVariable String email) {
//        Reuniao reuniao = reuniaoService.obterReuniaobyId(email);
//        List<Participante> participantes = participanteRepository.findByEmail(email);
//        return new ResponseEntity<>(participantes, HttpStatus.OK);
//    }
//}
}