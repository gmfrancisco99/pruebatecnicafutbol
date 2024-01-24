package com.gastonmunoz.pruebaTecnicaFutbol.service;

import com.gastonmunoz.pruebaTecnicaFutbol.entity.User;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.request.LoginReq;
import com.gastonmunoz.pruebaTecnicaFutbol.entity.response.LoginRes;

public interface AuthService {
    public LoginRes login(LoginReq loginReq);

    public User register(LoginReq loginReq);
}
