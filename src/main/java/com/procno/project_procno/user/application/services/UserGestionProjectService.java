package com.procno.project_procno.user.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procno.project_procno.container.domain.models.Container;
import com.procno.project_procno.container.infrastructure.repositories.ContainerRepository;
import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.project.domain.models.Project;
import com.procno.project_procno.project.infrastructure.repositories.ProjectRepository;
import com.procno.project_procno.user.domain.exceptions.UserNotFoundException;
import com.procno.project_procno.user.domain.models.User;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@Service
public class UserGestionProjectService {

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void userCreateProject(String username, Project entity){

        User userDB = userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException("user not found"));

        
        List<Element> elements = new ArrayList<>();

        Container containerForProject = new Container(null, "container"+entity.getTitle(), elements);

        Project projectToDB = new Project(null, entity.getTitle(), entity.getDescription(), containerForProject);;

        containerRepository.save(containerForProject);


        userDB.addProjects(projectToDB);


        projectRepository.save(projectToDB);
        userRepository.save(userDB);
    }
    public List<Project> findProjectsOfUser(String username){
        User userDB = userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException("user not found"));

        return userDB.getProjects();
    }
}
