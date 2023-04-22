package com.procno.project_procno.typeOfElement.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;

public interface TypeOfElementRepository extends JpaRepository<TypeOfElement, Long> {
    
}
