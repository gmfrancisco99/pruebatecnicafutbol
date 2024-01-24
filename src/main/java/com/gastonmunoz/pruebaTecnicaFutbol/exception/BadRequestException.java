package com.gastonmunoz.pruebaTecnicaFutbol.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
