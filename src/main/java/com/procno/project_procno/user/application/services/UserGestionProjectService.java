package com.procno.project_procno.user.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procno.project_procno.container.domain.models.Container;
import com.procno.project_procno.container.infrastructure.repositories.ContainerRepository;
import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.element.infrastructure.repositories.ElementRepository;
import com.procno.project_procno.project.domain.models.Project;
import com.procno.project_procno.project.infrastructure.repositories.ProjectRepository;
import com.procno.project_procno.typeOfContainer.domain.models.TypeOfContainer;
import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;
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

    @Autowired
    private ElementRepository elementRepository;

    public void userCreateProject(String username, Project entity){

        User userDB = userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException("user not found"));


        Project projectToDB = userCreateAkanbanProject(entity);

        containerRepository.save(projectToDB.getContainer());


        userDB.addProjects(projectToDB);


        projectRepository.save(projectToDB);
        userRepository.save(userDB);
    }
    public List<Project> findProjectsOfUser(String username){
        User userDB = userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException("user not found"));

        return userDB.getProjects();
    }
    private Project userCreateAkanbanProject(Project project){

        List<Element> elements = new ArrayList<>();

        TypeOfElement type = new TypeOfElement(4L,"box", false, "white", "black");

        Element elementToContainer = new Element(null, "container", new ArrayList<>(), null, type);
        elements.add( elementToContainer);

        elementRepository.save(elementToContainer);

        List<TypeOfContainer> typeOfContainer = new ArrayList<>();

        typeOfContainer.add(new TypeOfContainer(1L, "kanban"));

        Container containerForProject = new Container(null, "container"+project.getTitle(), elements, typeOfContainer);

        project.setContainer(containerForProject);


        return project;
    }
}
