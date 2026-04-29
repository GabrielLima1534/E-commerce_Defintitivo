package DTOs;

import entities.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PedidoDTO {

    private UUID id; // Mudando para UUID
    private LocalDate dataPedido; // Nome igual ao da Entity
    private String statusPedido;  // Nome igual ao da Entity
    private UsuarioDTO cliente;

    public PedidoDTO(Pedido entity) {
        this.id = entity.getId();
        this.dataPedido = entity.getDataPedido();
        this.statusPedido = entity.getStatusPedido();
        this.cliente = new UsuarioDTO(entity.getCliente());
    }
}
