package com.example.Ecommerce.services;

import com.example.Ecommerce.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Ecommerce.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(UUID id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria insert(Categoria obj) {
        return repository.save(obj);
    }
}
