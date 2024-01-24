package com.gastonmunoz.pruebaTecnicaFutbol.entity.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginReq {
    @NotBlank(message = "El nombre de usuario no debe estar vacío.")
    @Length(max = 30, message = "El nombre de usuario no puede tener más de 30 caracteres.")
    private String username;
    @NotBlank(message = "La contraseña no debe estar vacía.")
    @Length(max = 30, message = "La contraseña no debe tener más de 30 caracteres.")
    private String password;
}
