package com.example.Ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    private String descricao;

    @Column(nullable = false)
    private Double preco;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
