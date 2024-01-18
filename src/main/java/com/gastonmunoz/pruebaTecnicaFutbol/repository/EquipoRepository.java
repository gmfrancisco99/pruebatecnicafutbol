package com.gastonmunoz.pruebaTecnicaFutbol.repository;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer> {
}
