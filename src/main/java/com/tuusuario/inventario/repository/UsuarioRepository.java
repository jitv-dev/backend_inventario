package com.tuusuario.inventario.repository;

import com.tuusuario.inventario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByNombre(String nombre);
    boolean existsByEmail(String email);
}
