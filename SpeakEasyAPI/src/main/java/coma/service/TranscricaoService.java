package coma.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Base64;
/**
 * Serviço responsável por transcrição de áudio.
 */
@Service
public class TranscricaoService {

    public String realizarTranscricao(byte[] audioBytes) {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("https://*.cognitiveservices.azure.com/speechtotext/v3.0/transcriptions");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "459411e762394630a9539a53665811df");

            // Request body (assuming audioBytes is converted to a valid JSON string)
            String audioJson = converteAudio(audioBytes);
            StringEntity reqEntity = new StringEntity(audioJson);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity);
            } else {
                throw new RuntimeException("Resposta vazia do serviço de transcrição.");
            }
        } catch (Exception e) {
            // Log de erro
            System.err.println("Erro na transcrição de áudio: " + e.getMessage());
            // Lança uma exceção para ser tratada pelo controlador ou serviço superior
            throw new RuntimeException("Erro na transcrição de áudio.", e);
        }
    }
    /**
     * Converte bytes de áudio em formato JSON para envio para o serviço de transcrição.
     *
     * @param audioBytes Bytes do arquivo de áudio
     * @return String JSON representando os bytes de áudio
     */
    private String converteAudio(byte[] audioBytes) {
        // Converte o array de bytes em uma string Base64
        String base64Audio = Base64.getEncoder().encodeToString(audioBytes);

        // Cria um objeto JSON com a chave "audio" e o valor como a string Base64
        return "{ \"audio\": \"" + base64Audio + "\" }";
    }
}
