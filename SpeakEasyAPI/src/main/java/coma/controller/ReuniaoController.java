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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    /**
     * Obtém todas as reuniões.
     *
     * @return Lista de todas as reuniões
     */
    @GetMapping
    @Cacheable(value = "reunioesCache")
    public List<Reuniao> getAllReunioes() {
        return reuniaoRepository.findAll();
    }
    /**
     * Obtém uma reunião pelo ID.
     *
     * @param id ID da reunião
     * @return ResponseEntity contendo a reunião ou NOT_FOUND se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reuniao> getReuniaoById(@PathVariable String id) {
        log.info("Detalhando reunião com id: {}", id);

        return reuniaoRepository.findById(id)
                .map(reuniao -> new ResponseEntity<>(reuniao, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /**
     * Cria uma nova reunião.
     *
     * @param reuniao Dados da nova reunião
     * @return ResponseEntity contendo a reunião recém-criada
     */
    @PostMapping
    public ResponseEntity<Reuniao> createReuniao(@Valid @RequestBody Reuniao reuniao) {
        log.info("Cadastrando reunião: {}", reuniao);

        reuniao = reuniaoRepository.save(reuniao);
        return new ResponseEntity<>(reuniao, HttpStatus.CREATED);
    }
    /**
     * Atualiza uma reunião existente pelo ID.
     *
     * @param id      ID da reunião a ser atualizada
     * @param reuniao Dados atualizados da reunião
     * @return ResponseEntity contendo a reunião atualizada ou NOT_FOUND se não encontrada
     */
    @PutMapping("/{id}")
    @Transactional
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
    /**
     * Exclui uma reunião pelo ID.
     *
     * @param id ID da reunião a ser excluída
     * @return ResponseEntity sem conteúdo se excluída com sucesso ou NOT_FOUND se não encontrada
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteReuniao(@PathVariable("id") String id) {
        log.info("Apagando reunião com id: {}", id);

        return reuniaoRepository.findById(id)
                .map(reuniao -> {
                    reuniaoRepository.delete(reuniao);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cadastra um novo participante.
     *
     * @param participante Dados do novo participante
     * @return ResponseEntity contendo o participante recém-cadastrado
     */
    @PostMapping("/participante")
    public ResponseEntity<Participante> addParticipante(@Valid @RequestBody Participante participante) {
        log.info("Cadastrando participante: {}", participante);

        participante = participanteRepository.save(participante);
        return new ResponseEntity<>(participante, HttpStatus.CREATED);
    }

    /**
     * Obtém um participante pelo ID.
     *
     * @param id ID do participante
     * @return ResponseEntity contendo o participante ou NOT_FOUND se não encontrado
     */
    @GetMapping("/participante/{id}")
    @Async

    public ResponseEntity<Participante> getParticipanteById(@PathVariable String id) {
        log.info("Detalhando participante com id: {}", id);

        return participanteRepository.findById(id)
                .map(participante -> new ResponseEntity<>(participante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}