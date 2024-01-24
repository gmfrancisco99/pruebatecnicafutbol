package com.gastonmunoz.pruebaTecnicaFutbol.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorRes {
    Integer codigo;
    String mensaje;
}
