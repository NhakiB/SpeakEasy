package coma.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um participante no sistema.
 */
@Entity
@Data
@NoArgsConstructor

public class Participante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "reuniao_id", referencedColumnName = "id") // ajuste o referencedColumnName conforme necessário
    private Reuniao reuniao;





}
