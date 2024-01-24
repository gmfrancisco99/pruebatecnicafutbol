package com.gastonmunoz.pruebaTecnicaFutbol.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity(name = "EQUIPOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "El nombre del equipo no debe estar vacío.")
    @Length(max = 100, message = "El nombre no puede tener más de 100 caracteres.")
    private String nombre;

    @NotBlank(message = "La liga del equipo no debe estar vacía.")
    @Length(max = 100, message = "La liga no puede tener más de 100 caracteres.")
    private String liga;

    @NotBlank(message = "El país del equipo no debe estar vacío.")
    @Length(max = 100, message = "El país no puede tener más de 100 caracteres.")
    private String pais;
}