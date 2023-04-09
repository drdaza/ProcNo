package com.procno.project_procno.project.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.project.domain.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    public Optional<Project> findByTitle(String title);
}
