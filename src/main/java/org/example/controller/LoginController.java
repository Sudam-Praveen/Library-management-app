package org.example.controller;

import org.example.dto.Login;
import org.example.entity.LoginEntity;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    LoginService loginService;
    @PutMapping("/check")
    public ResponseEntity<String> updateEmployee(@RequestBody Login login){
        if( loginService.findUser(login)) {
            return new ResponseEntity<>("Valid User", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid User", HttpStatus.NOT_ACCEPTABLE);

    }
    @PostMapping("/add")
    public ResponseEntity<LoginEntity> addUser(@RequestBody Login login){
        LoginEntity newUser = loginService.addUser(login);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}