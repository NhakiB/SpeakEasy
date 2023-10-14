package coma.example.SpeakEasyAPI;




import coma.models.Usuario;
import coma.repository.UsuarioRepository;
import coma.service.UsuarioService;
import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.transaction.annotation.Transactional;

        import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SpeakEasyApiApplicationTests {
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Test
//    public void testObterUsuarioExistente() throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setEmail("test@example.com");
//        usuario.setSenha("b649129e5b37e23c4afd7489c5886cbbe15d47fb"); // Você deve usar uma senha criptografada aqu
//        usuario.setNome("Eduarda");
//        usuario.setPais("Brasil");
//        usuarioRepository.save(usuario);
//
//        Usuario usuarioObtido = usuarioService.obterUsuario(usuario.getId());
//        assertNotNull(usuarioObtido);
//        assertEquals("test@example.com", usuarioObtido.getEmail());
//    }
//
//    @Test
//    public void testObterUsuarioInexistente() {
//        assertThrows(Exception.class, () -> {
//            usuarioService.obterUsuario(999L); // ID inexistente
//        });
//    }
//
//    @Test
//    public void testLoginCorreto() {
//        Usuario usuario = new Usuario();
//        usuario.setEmail("test@example.com");
//        usuario.setSenha("$2a$10$b1KkY8QopE0x3xs16bmIN.uUd.BWcNT2npPFU2YhgsM8cZpYf0R1G"); // Senha criptografada
//
//        usuarioRepository.save(usuario);
//
//        boolean resultado = usuarioService.login("test@example.com", "password123");
//        assertTrue(resultado);
//    }
//
//    @Test
//    public void testLoginIncorreto() {
//        Usuario usuario = new Usuario();
//        usuario.setEmail("test@example.com");
//        usuario.setSenha("$2a$10$b1KkY8QopE0x3xs16bmIN.uUd.BWcNT2npPFU2YhgsM8cZpYf0R1G"); // Senha criptografada
//
//        usuarioRepository.save(usuario);
//
//        boolean resultado = usuarioService.login("test@example.com", "wrongpassword");
//        assertFalse(resultado);
//    }
}
