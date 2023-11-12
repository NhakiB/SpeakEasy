package coma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entidade que representa uma reunião no sistema.
 */
@Entity
@Data
@NoArgsConstructor
public class Reuniao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String titulo;
    private String descricao;
    private LocalDateTime data;
    @Lob
    private byte[] audioFile;
    @JsonIgnore
    private boolean ativo = true;
    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Usuario organizador;

    @OneToMany(mappedBy = "reuniao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participante> participantes = new ArrayList<>();


    public Reuniao(String titulo, String descricao, LocalDateTime data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }
}
