package com.procno.project_procno.typeOfContainer.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.typeOfContainer.domain.models.TypeOfContainer;

public interface TypeOfContainerRepository extends JpaRepository<TypeOfContainer, Long> {
    
}
