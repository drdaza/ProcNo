package com.procno.project_procno.user.application.services;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.procno.project_procno.user.domain.models.User;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@Service
public class RegisterService {
    
    private UserRepository repository;

    public RegisterService(UserRepository repository) {
        this.repository = repository;
    }

    public User store(User user) {
        PasswordEncoder enconder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = enconder.encode(user.getPassword());

        user.setPassword(password);

        return repository.save(user);
    }
}
