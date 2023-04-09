package com.procno.project_procno.project.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.procno.project_procno.interfaces.services.AdminService;
import com.procno.project_procno.interfaces.services.BasicService;
import com.procno.project_procno.project.domain.exceptions.ProjectNotFoundException;
import com.procno.project_procno.project.domain.models.Project;
import com.procno.project_procno.project.infrastructure.repositories.ProjectRepository;

@Service
public class ProjectGestionService implements AdminService<Project, Long>, BasicService<Project, Long>{

    private ProjectRepository projectRepository;

    public ProjectGestionService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void delete(Long id) {
        Project projectDB = projectRepository.findById(id).orElseThrow(()-> new ProjectNotFoundException("project not found"));
        
        projectRepository.delete(projectDB);
    }

    @Override
    public List<Project> listAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project update(Long id, Project entity) {
        return projectRepository.findById(id).map(projectUpdate -> {
            projectUpdate.setTitle(entity.getTitle());
            projectUpdate.setDescription(entity.getDescription());
            return projectRepository.save(projectUpdate);
        }).orElseThrow(()-> new ProjectNotFoundException("project not found"));
    }

    @Override
    public Project getOne(Long id) {
        return projectRepository.findById(id).orElseThrow(()-> new ProjectNotFoundException("project not found"));
    }

    @Override
    public Project save(Project entity) {
        return projectRepository.save(entity);
    }
    
    
}
