package com.tuusuario.inventario.controller;

import com.tuusuario.inventario.dto.request.LoginRequest;
import com.tuusuario.inventario.dto.request.RegisterRequest;
import com.tuusuario.inventario.dto.response.AuthResponse;
import com.tuusuario.inventario.dto.response.UsuarioResponse;
import com.tuusuario.inventario.model.Usuario;
import com.tuusuario.inventario.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioResponse> register(@Valid @RequestBody RegisterRequest request) {
        Usuario usuario = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.fromEntity(usuario));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponse> me(Authentication authentication) {
        Usuario usuario = authService.buscarPorEmail(authentication.getName());
        return ResponseEntity.ok(UsuarioResponse.fromEntity(usuario));
    }
}
