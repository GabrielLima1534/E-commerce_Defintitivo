package DTOs;

import entities.ItemPedido;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ItemPedidoDTO {

    private UUID id;
    private UUID produtoId;
    private String produtoNome;
    private Integer quantidade;
    private Double precoUnitario;
    private Double subTotal;

    public ItemPedidoDTO(ItemPedido entity) {
        this.id = entity.getId();
        this.produtoId = entity.getProduto().getId();
        this.produtoNome = entity.getProduto().getNome();
        this.quantidade = entity.getQuantidade();
        this.precoUnitario = entity.getPrecoUnitario();
        this.subTotal = entity.getQuantidade() * entity.getPrecoUnitario();
    }
}
