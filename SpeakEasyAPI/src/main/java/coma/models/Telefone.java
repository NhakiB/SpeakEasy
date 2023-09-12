package coma.models;

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

public class Telefone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "EX: 55")
    private int numeroDDD;

    @NotNull(message = "EX: 11")
    private int numeroDDI;

    @NotNull(message = "EX: 99999999")
    private int nrTelefone;
    @JsonIgnore
    private boolean ativo = true;

}
