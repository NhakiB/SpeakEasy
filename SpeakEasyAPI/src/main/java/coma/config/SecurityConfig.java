package coma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/**
 * Configurações de segurança para a aplicação.
 * Define as regras de acesso para diferentes endpoints e recursos.
 */
@Configuration
public class SecurityConfig  {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
