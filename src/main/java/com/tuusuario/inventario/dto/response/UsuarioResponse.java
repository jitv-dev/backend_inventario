package com.tuusuario.inventario.dto.response;

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
}
