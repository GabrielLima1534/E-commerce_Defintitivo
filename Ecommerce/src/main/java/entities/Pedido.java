package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable = false)
    private LocalDate dataPedido;


    private String statusPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
}
