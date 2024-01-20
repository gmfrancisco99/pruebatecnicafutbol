package com.gastonmunoz.pruebaTecnicaFutbol.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "El nombre del equipo no debe estar vacío.")
    private String nombre;

    @NotBlank(message = "La liga del equipo no debe estar vacía.")
    private String liga;

    @NotBlank(message = "El país del equipo no debe estar vacío.")
    private String pais;
}
