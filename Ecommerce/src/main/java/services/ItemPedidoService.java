package services;

import entities.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ItemPedidoRepository;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repository;

    public List<ItemPedido> findAll() {
        return repository.findAll();
    }

    public ItemPedido insert(ItemPedido obj) {
        return repository.save(obj);
    }
}
