package com.example.Ecommerce.services;

import com.example.Ecommerce.entities.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Ecommerce.repositories.ItemPedidoRepository;

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
