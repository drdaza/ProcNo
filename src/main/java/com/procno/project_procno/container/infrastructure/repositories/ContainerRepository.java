package com.procno.project_procno.container.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.container.domain.models.Container;

public interface ContainerRepository extends JpaRepository<Container, Long> {
    
}
