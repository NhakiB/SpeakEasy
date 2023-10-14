package coma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entidade que representa um resumo no sistema.
 */
@Entity
@Data
@NoArgsConstructor
public class Resumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String textoTranscrito;
    @NotBlank
    private String textoResumido;
    @ManyToOne
    @JoinColumn(name = "reuniao_id")
    private Reuniao reuniao;
    @JsonIgnore
    private boolean ativo = true;
}
