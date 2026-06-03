package com.tuusuario.inventario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    public String token;
    public String rol;
}
