package com.procno.project_procno.typeOfElement.infrastructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procno.project_procno.typeOfElement.application.services.TypesOfElementService;
import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;


@RestController
@RequestMapping(path = "/api/typeOfElement")
public class TypesOfElementController {
    
    private TypesOfElementService typesOfElementService;

    public TypesOfElementController(TypesOfElementService typesOfElementService) {
        this.typesOfElementService = typesOfElementService;
    }
    
    @GetMapping(value="")
    public List<TypeOfElement> listAllTypesOfElements() {
        return typesOfElementService.listAllTypeOfElements();
    }
    
}
