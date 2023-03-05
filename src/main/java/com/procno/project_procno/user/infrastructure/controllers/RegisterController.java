package com.procno.project_procno.user.infrastructure.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procno.project_procno.user.application.services.RegisterService;
import com.procno.project_procno.user.domain.models.User;



@RestController
@RequestMapping(path = "/api")
public class RegisterController {
    
    private RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody User user) {
        
        try {
            service.store(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);        }
        
    }
}
