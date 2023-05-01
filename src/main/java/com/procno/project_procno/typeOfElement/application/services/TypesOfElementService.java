package com.procno.project_procno.typeOfElement.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;
import com.procno.project_procno.typeOfElement.infrastructure.repositories.TypeOfElementRepository;

@Service
public class TypesOfElementService {
    
    private TypeOfElementRepository typeOfElementRepository;

    public TypesOfElementService(TypeOfElementRepository typeOfElementRepository) {
        this.typeOfElementRepository = typeOfElementRepository;
    }

    public List<TypeOfElement> listAllTypeOfElements(){
        return typeOfElementRepository.findAll();
    }
    
}
