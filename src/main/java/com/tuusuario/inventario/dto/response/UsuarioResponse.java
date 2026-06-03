package com.tuusuario.inventario.dto.response;

import com.tuusuario.inventario.model.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {
    private Long id;
    private String nombre;
    private String email;
    private String rol;
    private Boolean activo;
    private String creadoEn;

    public static UsuarioResponse fromEntity(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .rol(usuario.getRol().name())
                .activo(usuario.getActivo())
                .creadoEn(usuario.getCreadoEn().toString())
                .build();
    }
}
