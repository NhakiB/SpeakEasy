package coma.models;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Reuniao {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    private String descricao;

    @NotBlank
    private String duracao;

    @NotNull
    private ZonedDateTime data;

    private ZonedDateTime dataAlteracao;


    private Byte audio;
    @JsonIgnore
    private boolean ativo = true;
    
}
