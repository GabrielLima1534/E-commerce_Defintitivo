package com.example.Ecommerce.DTOs;

import com.example.Ecommerce.entities.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ProdutoDTO {

    private UUID id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imgUrl;

    public ProdutoDTO(Produto entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.imgUrl = entity.getImgUrl();
    }
}
