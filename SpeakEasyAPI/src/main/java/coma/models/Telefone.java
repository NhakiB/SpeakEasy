package coma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entidade que representa um telefone no sistema.
 */
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
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
