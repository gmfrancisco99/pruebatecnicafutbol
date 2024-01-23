package com.gastonmunoz.pruebaTecnicaFutbol.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRes {
    private String username;
    private String token;
}
