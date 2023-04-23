package com.procno.project_procno.project.infrastructure.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procno.project_procno.element.domain.payloads.TaskCreatePayload;
import com.procno.project_procno.project.application.services.ProjectGestionContainerService;

@RestController
@RequestMapping(path = "/api/user")
public class ProjectGestionContainerController {
    private ProjectGestionContainerService projectGestionContainerService;

    public ProjectGestionContainerController(ProjectGestionContainerService projectGestionContainerService) {
        this.projectGestionContainerService = projectGestionContainerService;
    }

    @PutMapping(value = "/project/{idProject}/container/{idContainer}/state/{idState}")
    public ResponseEntity<Map<String,String>> addTask(@RequestBody TaskCreatePayload payload, @PathVariable Long idProject, @PathVariable Long idContainer, @PathVariable Long idState) {
        try {
            projectGestionContainerService.addNewTaskToState(idProject, idContainer, idState, payload);

            Map<String, String> json = new HashMap<>();

            json.put("message", "succesfully task added");

            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {

            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }
}
