package coma.controller;

import coma.exceptions.RestNotFoundException;
import coma.models.Resumo;
import coma.repository.ResumoRepository;
import coma.service.ResumoService;
import coma.service.TranscricaoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * Controlador para operações relacionadas a transcrição e resumo na API.
 */
@RestController(value = "/resumo")
//@Tag(name = "Resumo")
@RequestMapping("/api/resumo")
public class TranscricaoResumoController {
    Logger log = LoggerFactory.getLogger(ReuniaoController.class);
    private final TranscricaoService transcricaoService;
    private final ResumoService resumoService;
    @Autowired
    ResumoRepository resumoRepository;

    @Autowired
    public TranscricaoResumoController(TranscricaoService transcricaoService, ResumoService resumoService) {
        this.transcricaoService = transcricaoService;
        this.resumoService = resumoService;
    }

    @PostMapping("/transcricao")
    public ResponseEntity<String> realizarTranscricao(@RequestParam("audio") MultipartFile audioFile) {
        try {
            byte[] audioBytes = audioFile.getBytes();
            String textoTranscrito = transcricaoService.realizarTranscricao(audioBytes);



            return ResponseEntity.ok(textoTranscrito);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na transcrição de áudio: " + e.getMessage());
        }
    }

    @PostMapping("/resumo")
    public ResponseEntity<String> realizarResumo(@RequestParam("texto") String textoTranscrito) {
        try {
            String textoResumido = resumoService.resumirTexto(textoTranscrito);



            return ResponseEntity.ok(textoResumido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao gerar resumo: " + e.getMessage());
        }
    }
    /**
     * Obtém a lista de todos os resumos cadastrados.
     *
     * @return Lista de resumos cadastrados
     */
        @GetMapping()
        public List<Resumo> show(){
            return resumoRepository.findAll();
        }

        @GetMapping("{id}")
        public ResponseEntity<Resumo> show(@PathVariable Long id){
            log.info("detalhando Resumo com id" + id);
            return ResponseEntity.ok(getResumo(id));
        }

    /**
     * Atualiza as informações de um resumo existente.
     *
     * @param id      ID do resumo a ser atualizado
     * @param resumo Dados atualizados do resumo
     * @return O resumo atualizado
     */

        @PutMapping("{id}/resumo")
        public ResponseEntity<Resumo> update(@PathVariable Long id, @RequestBody @Valid Resumo resumo){
            log.info("atualizando resumo" + id);

            getResumo(id);

            resumo.setId(id);
            resumoRepository.save(resumo);

            return ResponseEntity.ok(resumo);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Resumo> destroy(@PathVariable Long id){
            log.info("apagando resumo" + id);
            var resumo = getResumo(id);
            resumo.setAtivo(false);
            resumoRepository.save(resumo);
            return ResponseEntity.noContent().build();
        }



        private Resumo getResumo(Long id) {
            var resumo = resumoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("resumo não encontrada"));
            return resumo;
        }


}

