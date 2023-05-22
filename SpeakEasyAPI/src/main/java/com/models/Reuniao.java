package com.models;

import java.time.ZonedDateTime;
    
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private ZonedDateTime data;

    private ZonedDateTime dataAlteracao;

    @NotBlank
    private Byte audio;

    
}
