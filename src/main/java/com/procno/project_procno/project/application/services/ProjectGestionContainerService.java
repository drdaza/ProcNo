package com.procno.project_procno.project.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procno.project_procno.container.domain.models.Container;
import com.procno.project_procno.container.infrastructure.repositories.ContainerRepository;
import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.element.domain.payloads.TaskCreatePayload;
import com.procno.project_procno.element.infrastructure.repositories.ElementRepository;
import com.procno.project_procno.project.domain.models.Project;
import com.procno.project_procno.project.infrastructure.repositories.ProjectRepository;
import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;
import com.procno.project_procno.typeOfElement.infrastructure.repositories.TypeOfElementRepository;

@Service
public class ProjectGestionContainerService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ElementRepository elementRepository;
    @Autowired 
    private TypeOfElementRepository typeOfElementRepository;

    public void addNewTaskToState(long idProject,Long idContainer, Long idState, TaskCreatePayload payload){
        Project projectDB = projectRepository.findById(idProject).orElseThrow(); //usco el projecto en la base de datos

        Container containerOfProjectDB = projectDB.getContainer(); // saco su contenedor

        Element stateDB = elementRepository.findById(idState).orElseThrow(); // usco el estado por su id en la base de datos

        List<Element> states = containerOfProjectDB.getElements(); // saco la lista de states del contenedor para poder buscar el state encontrado en la DB

        containerOfProjectDB.setElements(findState(states, stateDB, payload));
        
        projectDB.setContainer(containerOfProjectDB);

        containerRepository.save(containerOfProjectDB);

        projectRepository.save(projectDB);

    }
    private List<Element> findState(List<Element> states, Element StateToFind, TaskCreatePayload payload){

        TypeOfElement type = typeOfElementRepository.findByName(payload.getTypeElement()).orElseThrow();
        Element taskToAdd = new Element(null, payload.getName(), false, payload.getColor(), payload.getFontColor(), null, null, type);

        for (Element state : states) {
            if(state.equals(StateToFind)){
                List<Element> tasks = state.getSubElements();

                tasks.add(taskToAdd);
            }
        }

        elementRepository.save(taskToAdd);
        return states;
    }
}
