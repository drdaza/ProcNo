package com.procno.project_procno.user.application.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.procno.project_procno.role.domain.models.Role;
import com.procno.project_procno.user.domain.models.User;
import com.procno.project_procno.user.domain.payloads.RegisterPayload;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@Service
public class RegisterService {
    
    private UserRepository repository;

    public RegisterService(UserRepository repository) {
        this.repository = repository;
    }

    public User store(RegisterPayload infoUser) {

        byte[] decodifiedBytesUserPass = Base64.getDecoder().decode(infoUser.getUsernameAndPass());
        String decodifiedUsernameAndPass = new String(decodifiedBytesUserPass);
        List<String> userAndPassword = new ArrayList<>();

        userAndPassword.add(decodifiedUsernameAndPass.split(":")[0]);
        userAndPassword.add(decodifiedUsernameAndPass.split(":")[1]);

        byte[] decodifiedBytesEmailPass = Base64.getDecoder().decode(infoUser.getEmailAndPass());
        String decodifiedEmailAndPass = new String(decodifiedBytesEmailPass).split(":")[1];


        Set<Role> roles = new HashSet<>();
        Role UserRole = new Role(1L, "ROLE_USER"); 

        roles.add(UserRole);

        User user = new User(null, userAndPassword.get(0), userAndPassword.get(1), decodifiedEmailAndPass, roles);

        PasswordEncoder enconder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = enconder.encode(user.getPassword());

        user.setPassword(password);

        return repository.save(user);
    }
}
