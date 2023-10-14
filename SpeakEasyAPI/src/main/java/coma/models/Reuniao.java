package coma.models;

import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entidade que representa uma reunião no sistema.
 */
@Entity
@Data
@NoArgsConstructor

public class Reuniao {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar em branco")
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull(message = "A data não pode estar em branco")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private byte[] audioBytes;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @JsonIgnore
    private boolean ativo = true;
    
}
