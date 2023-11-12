package coma.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import coma.models.Resumo;
import coma.repository.ResumoRepository;
import okhttp3.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


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

        String apiKey = "sua_chave_de_api_aqui";
        String url = "https://api.openai.com/v1/engines/davinci/completions";

        // Modificado para incluir o pedido de resumo no prompt
        String json = "{\n" +
                "    \"prompt\": \"Resuma o seguinte texto: " + textoTranscrito + "\",\n" +


                "    \"max_tokens\": 50\n" +
                "}";

        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Autorização", "Bearer " + apiKey) .build();

        // Adiciona um log informativo antes de enviar a solicitação
        logger.info("Enviando solicitação para resumir texto: {}", json);

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String textoResumido = extrairTextoResumido(response.body().string());
                salvarResumo(textoTranscrito, textoResumido);
                return textoResumido;
            } else {
                throw new RuntimeException("Erro ao resumir texto. Código de resposta: " + response.code() +
                        ", Mensagem: " + response.message());
            }
        } catch (IOException e) {
            // Log de erro
            logger.error("Erro ao gerar resumo: {}", e.getMessage());
            throw e;
        }
    }

    private String extrairTextoResumido(String respostaAPI) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(respostaAPI);

            // Supondo que a resposta tenha uma chave "choices" e o texto resumido esteja em "text"
            if (jsonNode.has("choices")) {
                JsonNode choicesNode = jsonNode.get("choices");

                // Verificando se há pelo menos uma escolha
                if (choicesNode.isArray() && choicesNode.size() > 0) {
                    JsonNode primeiraEscolha = choicesNode.get(0);

                    // Verificando se a escolha tem o campo "text"
                    if (primeiraEscolha.has("text")) {
                        return primeiraEscolha.get("text").asText();
                    }
                }
            }return "Texto resumido não encontrado na resposta da API.";
                    } catch (IOException e) {
                    logger.error("Erro ao extrair texto resumido: {}", e.getMessage());
                    return "Erro ao extrair texto resumido.";
                    }
                    }

    public void salvarResumo(String textoTranscrito, String textoResumido) {


        Resumo resumo = new Resumo();
        resumo.setTextoTranscrito(textoTranscrito);
        resumo.setTextoResumido(textoResumido);

        resumoRepository.save(resumo);
    }
}