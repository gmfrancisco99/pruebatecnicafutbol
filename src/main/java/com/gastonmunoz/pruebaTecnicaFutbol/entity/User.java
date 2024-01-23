package com.gastonmunoz.pruebaTecnicaFutbol.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
