package com.gastonmunoz.pruebaTecnicaFutbol.service;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
import com.gastonmunoz.pruebaTecnicaFutbol.exception.EquipoNotFoundException;
import com.gastonmunoz.pruebaTecnicaFutbol.exception.InternalServerErrorException;
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
        Optional<Equipo> result;
        try{
            result = equipoRepository.findById(id);
            if (result.isEmpty()){
                throw new EquipoNotFoundException();
            }
        } catch (EquipoNotFoundException exception){
            throw exception;
        } catch (Exception exception){
            throw new InternalServerErrorException("Se ha producido un error inesperado");
        }
        return result.get();
    }

    @Override
    public List<Equipo> getAllEquiposByNombre(String nombre) {
        try{
            return equipoRepository.findAllByNombreContainingIgnoreCase(nombre);
        } catch (Exception exception){
            throw new InternalServerErrorException("Se ha producido un error inesperado");
        }
    }

    @Override
    public List<Equipo> getAllEquipos() {
        List<Equipo> result;
        try {
            result = equipoRepository.findAll();
        } catch (Exception exception){
            throw new InternalServerErrorException("Se ha producido un error inesperado");
        }
        return result;
    }

    @Override
    public Equipo updateEquipo(Integer id, Equipo updateEquipo) {
        try {
            boolean exists = equipoRepository.existsById(id);
            if (!exists) throw new EquipoNotFoundException();
            updateEquipo.setId(id);
            return equipoRepository.save(updateEquipo);
        } catch (EquipoNotFoundException exception){
           throw exception;
        } catch (Exception exception){
            throw new InternalServerErrorException("Se ha producido un error inesperado");
        }
    }

    @Override
    public void deleteEquipoById(Integer id) {
        try {
            boolean exists = equipoRepository.existsById(id);
            if (!exists) throw new EquipoNotFoundException();
            equipoRepository.deleteById(id);
        } catch (EquipoNotFoundException exception){
            throw exception;
        } catch (Exception exception) {
            throw new InternalServerErrorException("Se ha producido un error inesperado");
        }
    }
}
