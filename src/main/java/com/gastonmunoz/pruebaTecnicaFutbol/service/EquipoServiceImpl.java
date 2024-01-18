package com.gastonmunoz.pruebaTecnicaFutbol.service;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
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
    public Optional<Equipo> getEquipoById(Integer id) {
        return equipoRepository.findById(id);
    }

    @Override
    public List<Equipo> getAllEquipos() {
        return (List<Equipo>) equipoRepository.findAll();
    }

    @Override
    public Equipo updateEquipo(Integer id, Equipo updateEquipo) {
        return null;
    }

    @Override
    public void deleteEquipoById(Integer id) {
        equipoRepository.deleteById(id);
    }
}
