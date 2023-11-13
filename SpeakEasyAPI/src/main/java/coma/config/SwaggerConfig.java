package coma.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@Profile("!prod")
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    /**
     * Configuração da chave de autenticação JWT.
     */
    private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }
    /**
     * Configuração das informações da API para a interface do Swagger.
     */
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "SpeakEasy API",
                "SpeakEasy REST API Documentação",
                "1",
                "Terms of service",
                new Contact("Devall", "www.javaguides.net", "devall@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }

    /**
     * Configuração do Docket (Swagger) para a API.
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * Configuração do contexto de segurança para o Swagger.
     */
    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    /**
     * Configuração das referências de segurança padrão para o Swagger.
     */
    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}