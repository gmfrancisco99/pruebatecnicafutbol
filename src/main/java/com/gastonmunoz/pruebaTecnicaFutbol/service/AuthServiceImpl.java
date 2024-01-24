package com.gastonmunoz.pruebaTecnicaFutbol.service;

import com.gastonmunoz.pruebaTecnicaFutbol.auth.JwtUtil;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.User;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.request.LoginReq;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.response.LoginRes;
import com.gastonmunoz.pruebaTecnicaFutbol.exception.BadRequestException;
import com.gastonmunoz.pruebaTecnicaFutbol.exception.InternalServerErrorException;
import com.gastonmunoz.pruebaTecnicaFutbol.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService{
    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    private UserRepository userRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtil util, UserRepository userRepository){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = util;
        this.userRepository = userRepository;
    }

    @Override
    public LoginRes login(LoginReq loginReq) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
        String username = authentication.getName();
        User user = new User(username, "");
        String token = jwtUtil.createToken(user);

        return new LoginRes(username, token);
    }

    @Override
    public User register(LoginReq loginReq) {
        User userToRegister = new User(loginReq.getUsername(), loginReq.getPassword());
        User newUser = null;
        System.out.println("User:" + userToRegister.getUsername());
        try{

            boolean exists = userRepository.existsByUsername(userToRegister.getUsername());
            System.out.println("Acá llega, existe" + exists);
            if (exists){
                throw new BadRequestException("El nombre de usuario ya está siendo usado");
            }
            newUser = userRepository.save(userToRegister);

        } catch (BadRequestException ignored) {

        } catch (Exception exception) {
            throw new InternalServerErrorException("Se ha producido un error inesperado");
        }
        return newUser;
    }
}
