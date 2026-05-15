package com.example.Ecommerce.controllers;

import com.example.Ecommerce.DTOs.LoginRequestDTO;
import com.example.Ecommerce.DTOs.LoginResponseDTO;
import com.example.Ecommerce.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Ecommerce.repositories.UsuarioRepository;
import com.example.Ecommerce.security.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO data
    ) {

        Usuario usuario = usuarioRepository
                .findByEmail(data.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(data.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(
                usuario.getId(),
                usuario.getEmail()
        );

        return ResponseEntity.ok(
                new LoginResponseDTO(token)
        );
    }
}