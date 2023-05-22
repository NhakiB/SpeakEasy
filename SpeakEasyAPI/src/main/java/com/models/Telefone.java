package com.models;

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

public class Telefone {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "EX: 55")
    private int numeroDDD;

    @NotBlank(message = "EX: 11")
    private int numeroDDI;

    @NotBlank(message = "EX: 999999999")
    private int nrTelefone;
    
}
