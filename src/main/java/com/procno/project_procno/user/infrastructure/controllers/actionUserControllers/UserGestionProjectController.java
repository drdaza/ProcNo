package com.procno.project_procno.user.infrastructure.controllers.actionUserControllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procno.project_procno.project.domain.models.Project;
import com.procno.project_procno.user.application.services.UserGestionProjectService;

@RestController
@RequestMapping(path = "/api/user")
public class UserGestionProjectController {
    
    private UserGestionProjectService userGestionProjectService;

    public UserGestionProjectController(UserGestionProjectService userGestionProjectService) {
        this.userGestionProjectService = userGestionProjectService;
    }

    
    @PostMapping(value = "/createProject/{username}")
    public ResponseEntity<Map<String, String>> createPorject(@RequestBody Project project, @PathVariable String username){
        try {
            
            userGestionProjectService.userCreateProject(username, project);

            Map<String, String> json = new HashMap<>();

            json.put("message", "project create");

            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json); 
        }
    }
    @GetMapping(value = "/allProjects/{username}")
    public List<Project> listAllProjects(@PathVariable String username){
        return userGestionProjectService.findProjectsOfUser(username);
    }
}
