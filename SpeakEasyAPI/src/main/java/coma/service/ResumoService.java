package coma.service;

import coma.models.Resumo;
import coma.repository.ResumoRepository;
import okhttp3.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;
/**
 * Serviço responsável por lógica de negócios relacionada aos resumos.
 */
@Service
public class ResumoService {
    private final OkHttpClient client = new OkHttpClient();
    private static final Logger logger = LoggerFactory.getLogger(ResumoService.class);
    private final ResumoRepository resumoRepository;

    @Autowired
    public ResumoService(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }
    public String resumirTexto(String textoTranscrito) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");

        String json = "{\n" +
                "    \"prompt\": \"" + textoTranscrito + "\",\n" +
                "    \"max_tokens\": 50\n" +
                "}";

        RequestBody body = RequestBody.create(mediaType, json);

        String apiKey = "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";
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new RuntimeException("Erro ao resumir texto. Código de resposta: " + response.code() +
                        ", Mensagem: " + response.message());
            }
        } catch (IOException e) {
            // Log de erro
            logger.error("Erro ao gerar resumo: {}", e.getMessage());

        }
        return json;

    }
    /**
     * Obtém um resumo pelo seu ID.
     *
     * @param id ID do resumo a ser obtido
     * @return O resumo com o ID especificado
     * @throws Exception Se o resumo não for encontrado
     */
    @Cacheable(value = "resumoCache", key = "id")
    @Transactional(readOnly = true)
    public Resumo obterResumo(Long id) throws Exception {
        Optional<Resumo> resumoOptional = resumoRepository.findById(id);
        if (resumoOptional.isPresent()) {
            return resumoOptional.get();
        } else {
            throw new Exception("Resumo não encontrado com o id: " + id);
        }
    }
    @Async
    @Transactional

    public boolean resumoValida(String textoResumido) {
        Resumo resumo = resumoRepository.findBytextoResumido(textoResumido) ;
        if (resumo == null) {
            return false;
        }
        else if (resumo.getTextoTranscrito() == textoResumido){
            return true;
        }
        else{
            return false;
        }
    }
    public void salvarResumo(String textoTranscrito, String textoResumido) {
        Resumo resumo = new Resumo();
        resumo.setTextoTranscrito(textoTranscrito);
        resumo.setTextoResumido(textoResumido);

        resumoRepository.save(resumo);
    }
}
