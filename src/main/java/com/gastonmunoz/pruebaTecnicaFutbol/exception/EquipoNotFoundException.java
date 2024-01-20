package com.gastonmunoz.pruebaTecnicaFutbol.exception;

public class EquipoNotFoundException extends RuntimeException{
    public EquipoNotFoundException(){
        super("Equipo no encontrado");
    }
}
