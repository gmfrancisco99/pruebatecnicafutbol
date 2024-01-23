package com.gastonmunoz.pruebaTecnicaFutbol.controller;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
import com.gastonmunoz.pruebaTecnicaFutbol.service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/equipos/{id}")
    public Equipo getEquipoById(@PathVariable("id") Integer equipoId){
        return equipoService.getEquipoById(equipoId);
    }

    @GetMapping("/equipos/buscar")
    public List<Equipo> getAllEquiposByNombre(@RequestParam String nombre){
        return equipoService.getAllEquiposByNombre(nombre);
    }

    @GetMapping("/equipos")
    public List<Equipo> getAllEquipos(){
        return equipoService.getAllEquipos();
    }

    @PutMapping("/equipos/{id}")
    public Equipo updateEquipo(@Valid @RequestBody Equipo updateEquipo, @PathVariable("id") Integer equipoId){
        return equipoService.updateEquipo(equipoId, updateEquipo);
    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<?> deleteEquipoById(@PathVariable("id") Integer equipoId){
        equipoService.deleteEquipoById(equipoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //TODO: Add annotations with included message to ids path variables to validate them on the spot

}
