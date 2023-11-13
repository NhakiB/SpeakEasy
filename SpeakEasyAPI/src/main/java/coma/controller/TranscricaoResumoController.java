package coma.controller;

import coma.exceptions.RestNotFoundException;
import coma.models.Resumo;
import coma.models.Usuario;
import coma.repository.ResumoRepository;
import coma.service.ResumoService;
import coma.service.TranscricaoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * Controlador para operações relacionadas a transcrição e resumo na API.
 */
@RestController
@RequestMapping("/api")
public class TranscricaoResumoController {
    Logger log = LoggerFactory.getLogger(TranscricaoResumoController.class);
    private final TranscricaoService transcricaoService;
    private final ResumoService resumoService;
    @Autowired
    private ResumoRepository resumoRepository;

    @Autowired
    public TranscricaoResumoController(TranscricaoService transcricaoService, ResumoService resumoService) {
        this.transcricaoService = transcricaoService;
        this.resumoService = resumoService;
    }
    /**
     * Realiza a transcrição de um arquivo de áudio.
     *
     * @param audioFile Arquivo de áudio a ser transcrito
     * @return ResponseEntity contendo o texto transcrito ou um status de erro
     */
    @PostMapping("/transcricao")
    @Async
    public ResponseEntity<String> realizarTranscricao(@RequestParam("audio") MultipartFile audioFile) {
        try {
            byte[] audioBytes = audioFile.getBytes();
            String textoTranscrito = transcricaoService.realizarTranscricao(audioBytes);



            return ResponseEntity.ok(textoTranscrito);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro na transcrição de áudio: " + e.getMessage());
        }
    }
    /**
     * Realiza um resumo com base no texto transcrito.
     *
     * @param resumo Objeto Resumo contendo o texto transcrito
     * @return ResponseEntity contendo o texto resumido ou um status de erro
     */
    @PostMapping("/resumo")
    @Operation(summary = "Realizar Resumo", description = "Realiza um resumo com base no texto transcrito.")
    @Transactional
    public ResponseEntity<String> realizarResumo(@RequestBody @Valid Resumo resumo) {
        try {
            // Use resumo.getTextoTranscrito() ou algo semelhante, dependendo da estrutura do Resumo
            String textoResumido = resumoService.resumirTexto(resumo.getTextoTranscrito());
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
        @Cacheable(value = "resumosCache")
        public List<Resumo> show(){
            return resumoRepository.findAll();
        }

    @GetMapping("/{id}")
    public ResponseEntity<Resumo> getResumoById(@PathVariable String id) {
        log.info("Detalhando Resumo com id " + id);
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
        @Transactional
        public ResponseEntity<Resumo> update(@PathVariable String id, @RequestBody @Valid Resumo resumo){
            log.info("atualizando resumo" + id);

            getResumo(id);

            resumo.setId(id);
            resumoRepository.save(resumo);

            return ResponseEntity.ok(resumo);
        }
    /**
     * Exclui um resumo pelo ID.
     *
     * @param id ID do resumo a ser excluído
     * @return ResponseEntity sem conteúdo se excluído com sucesso ou NOT_FOUND se não encontrado
     */
        @DeleteMapping("{id}")
        @Transactional
        public ResponseEntity<Resumo> destroy(@PathVariable String id){
            log.info("apagando resumo" + id);
            var resumo = getResumo(id);
            resumoRepository.save(resumo);
            return ResponseEntity.noContent().build();
        }



        private Resumo getResumo(String id) {
            var resumo = resumoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("resumo não encontrado"));
            return resumo;
        }


}

