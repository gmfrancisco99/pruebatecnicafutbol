package com.gastonmunoz.pruebaTecnicaFutbol.repository;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer>, JpaRepository<Equipo, Integer> {
    List<Equipo> findAllByNombreContainingIgnoreCase(String nombre);
}
