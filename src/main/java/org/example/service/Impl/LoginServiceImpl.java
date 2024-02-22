package org.example.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Login;
import org.example.entity.LoginEntity;
import org.example.repository.LoginRepo;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepo loginRepo;
    @Autowired
    ObjectMapper objectMapper;
    public LoginEntity addUser(Login login) {
        LoginEntity loginEntity = objectMapper.convertValue(login, LoginEntity.class);
        return loginRepo.save(loginEntity);
    }

    @Override
    public boolean findUser(Login login) {
        List<LoginEntity> all = loginRepo.findAll();
        for (LoginEntity user:all) {
            if(login.getEmail().equalsIgnoreCase(user.getEmail())
                    && login.getPassword().equalsIgnoreCase(user.getPassword()) ){
                return true;
            }

        }

        return false;
    }
}
