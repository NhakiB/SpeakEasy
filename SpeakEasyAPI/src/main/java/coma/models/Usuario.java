package coma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * Entidade que representa um usuário no sistema.
 */
@Entity
@Data
@NoArgsConstructor

public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "usuario_seq", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    private String id;
    private String nome;
    @Email
    private String email;
    private String senha;





    @JsonIgnore
    private boolean ativo = true;


    public Usuario(String nome, String email, String senha) {
    }
}
