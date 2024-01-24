package com.gastonmunoz.pruebaTecnicaFutbol.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EquipoNotFoundException.class)
    public ResponseEntity<?> handleEquipoNotFoundException(EquipoNotFoundException exc, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("codigo", HttpStatus.NOT_FOUND.value());
        body.put("mensaje", exc.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exc, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("codigo", HttpStatus.BAD_REQUEST.value());
        body.put("mensaje", exc.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<?> handleInternalServerErrorException(InternalServerErrorException exc, WebRequest request){
        Map<String,Object> body = new HashMap<>();
        body.put("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("mensaje", exc.getMessage());

        return  new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request){
        Map<String,Object> body = new HashMap<>();
        body.put("codigo", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);
        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }
}
