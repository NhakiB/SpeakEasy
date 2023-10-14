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


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank(message = "Insira um email válido")
    private String email;

    @NotBlank(message = "Insira uma senha válida")
    private String senha;

    @NotBlank
    private String nome;

    @NotBlank
    private String pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Telefone> telefones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Reuniao> reunioes;
    @JsonIgnore
    private boolean ativo = true;

    
}
