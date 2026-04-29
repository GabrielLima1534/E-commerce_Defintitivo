package services;

import entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PedidoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido insert(Pedido obj) {
        obj.setDataPedido(LocalDate.now());

        if (obj.getStatusPedido() == null) {
            obj.setStatusPedido("AGUARDANDO_PAGAMENTO");
        }

        return repository.save(obj);
    }
}
