package org.example.service;

import org.example.dto.Login;
import org.example.entity.LoginEntity;

public interface LoginService {
    public boolean findUser(Login login);
    public LoginEntity addUser(Login login);
}