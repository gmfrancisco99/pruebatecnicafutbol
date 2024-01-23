package com.gastonmunoz.pruebaTecnicaFutbol.controller;

import com.gastonmunoz.pruebaTecnicaFutbol.auth.JwtUtil;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.User;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.request.LoginReq;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.response.ErrorRes;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.response.LoginRes;
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

    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil util){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = util;
    }

    @PostMapping("/auth/login")
    public ResponseEntity login(@RequestBody LoginReq loginReq) {
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
            String username = authentication.getName();
            User user = new User(username, "");
            String token = jwtUtil.createToken(user);
            LoginRes loginRes = new LoginRes(username, token);

            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
