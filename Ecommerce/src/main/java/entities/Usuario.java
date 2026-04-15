package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name = "usuarios")
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;
    private String telefone;

    @Column(nullable = false)
    private String senha;


}
