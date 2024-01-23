package com.gastonmunoz.pruebaTecnicaFutbol.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginReq {
    private String username;
    private String password;
}
