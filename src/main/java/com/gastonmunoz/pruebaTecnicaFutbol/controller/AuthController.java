package com.gastonmunoz.pruebaTecnicaFutbol.controller;

import com.gastonmunoz.pruebaTecnicaFutbol.auth.JwtUtil;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.User;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.request.LoginReq;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.response.ErrorRes;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.response.LoginRes;
import com.gastonmunoz.pruebaTecnicaFutbol.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity login(@Valid @RequestBody LoginReq loginReq) {
        try {
            LoginRes loginRes =  authService.login(loginReq);
            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST.value(), "Nombre de usuario o contraseña inválidos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PostMapping("/auth/register")
    public User register(@Valid @RequestBody LoginReq loginReq) {
        User newUser = authService.register(loginReq);
        newUser.setId(null);
        return newUser;
    }
}
