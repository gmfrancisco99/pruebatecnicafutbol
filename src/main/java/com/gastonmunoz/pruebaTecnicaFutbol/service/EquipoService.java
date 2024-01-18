package com.gastonmunoz.pruebaTecnicaFutbol.service;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {
    Optional<Equipo> getEquipoById(Integer id);
    List<Equipo> getAllEquipos();
    Equipo updateEquipo(Integer id, Equipo updateEquipo);
    void deleteEquipoById(Integer id);
}