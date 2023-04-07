package com.procno.project_procno.user.infrastructure.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procno.project_procno.profile.domain.payloads.EditProfilePayload;
import com.procno.project_procno.user.application.services.UserInfoService;
import com.procno.project_procno.user.domain.models.User;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    private UserInfoService UserInfoService;

    public UserController(com.procno.project_procno.user.application.services.UserInfoService userInfoService) {
        UserInfoService = userInfoService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Map<String, String>> userInfo(@PathVariable String username) {
        try {
            User userDB = UserInfoService.getOne(username);

            Map<String, String> json = new HashMap<>();

            json.put("username", userDB.getUsername());
            json.put("email", userDB.getEmail());
            json.put("name", userDB.getProfile().getName());
            json.put("lastName", userDB.getProfile().getLastName());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("Error", e.getMessage());
            json.put("Cause", e.getCause().toString());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }

    @PutMapping(value = "edit/{username}")
    public ResponseEntity<Map<String, String>> UpdateUserInfo(@PathVariable String username,
            @RequestBody EditProfilePayload entity) {
        try {
            EditProfilePayload responseDB = UserInfoService.update(username, entity);

            Map<String, String> json = new HashMap<>();

            json.put("email", responseDB.getEmail());
            json.put("name", responseDB.getName());
            json.put("lastName", responseDB.getLastName());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("Error", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }
}
