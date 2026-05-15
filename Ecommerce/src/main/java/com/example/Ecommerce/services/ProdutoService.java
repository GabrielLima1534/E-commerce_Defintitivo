package com.example.Ecommerce.services;

import com.example.Ecommerce.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Ecommerce.repositories.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    // No seu ProdutoService.java
    public Produto findById(UUID id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto insert(Produto obj) {
        return repository.save(obj);
    }
}
