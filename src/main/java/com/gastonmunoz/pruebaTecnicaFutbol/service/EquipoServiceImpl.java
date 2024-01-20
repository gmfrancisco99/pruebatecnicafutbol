package com.gastonmunoz.pruebaTecnicaFutbol.service;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
import com.gastonmunoz.pruebaTecnicaFutbol.exception.EquipoNotFoundException;
import com.gastonmunoz.pruebaTecnicaFutbol.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService{
    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public Equipo getEquipoById(Integer id) {
        Optional<Equipo> result = equipoRepository.findById(id);

        if (!result.isPresent()){
            throw new EquipoNotFoundException();
        }
        return result.get();
    }

    @Override
    public List<Equipo> getAllEquiposByNombre(String nombre) {
        return equipoRepository.findAllByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo updateEquipo(Integer id, Equipo updateEquipo) {
        boolean exists = equipoRepository.existsById(id);
        if (!exists) throw new EquipoNotFoundException();
        updateEquipo.setId(id);
        return equipoRepository.save(updateEquipo);
    }

    @Override
    public void deleteEquipoById(Integer id) {
        boolean exists = equipoRepository.existsById(id);
        if (!exists) throw new EquipoNotFoundException();
        equipoRepository.deleteById(id);
    }
}
