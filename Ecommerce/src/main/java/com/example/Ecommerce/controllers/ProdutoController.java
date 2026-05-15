package com.example.Ecommerce.controllers;

import com.example.Ecommerce.DTOs.ProdutoDTO;
import com.example.Ecommerce.entities.Produto;
import com.example.Ecommerce.repositories.ProdutoRepository;
import com.example.Ecommerce.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Ecommerce.services.ProdutoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> list = service.findAll();
        List<ProdutoDTO> listDto = list.stream().map(ProdutoDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable UUID id) {
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PostMapping("/{id}/photo")
    public ResponseEntity<String> uploadPhoto(
            @PathVariable UUID id,
            @RequestParam("file") MultipartFile file) throws IOException {

        String fileName = photoService.savePhoto(file);

        Produto produto = service.findById(id);

        produto.setImgUrl(fileName);

        service.insert(produto);

        return ResponseEntity.ok("Foto do produto enviada");
    }



}
