package coma.example.SpeakEasyAPI;


import coma.models.Reuniao;
import coma.models.Usuario;
import coma.service.ReuniaoService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SpeakEasyApiApplicationTests {
    @Autowired
    private ReuniaoService reuniaoService;

    @Test
    public void testEnviarParaOrganizador() {
        // Criar uma reunião de teste
        Reuniao reuniao = new Reuniao();
        reuniao.setTitulo("Título de Teste");

        // Obter o organizador da reunião
        Usuario organizador = new Usuario();
        organizador.setEmail("organizador@teste.com");
        reuniao.setOrganizador(organizador);

        // Chamar o método que envia o e-mail
        try {
            reuniaoService.enviarParaOrganizador(reuniao);

            // Se chegou até aqui sem lançar exceções, consideramos o teste bem-sucedido
            assertTrue(true);
        } catch (Exception e) {
            // Se lançar uma exceção, consideramos o teste falho
            fail("Erro ao enviar e-mail para o organizador: " + e.getMessage());
        }
    }

}