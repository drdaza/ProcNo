package com.procno.project_procno.project.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procno.project_procno.container.domain.models.Container;
import com.procno.project_procno.container.infrastructure.repositories.ContainerRepository;
import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.element.domain.payloads.TaskCreatePayload;
import com.procno.project_procno.element.infrastructure.repositories.ElementRepository;
import com.procno.project_procno.elemetInfo.domain.models.ElementInfo;
import com.procno.project_procno.elemetInfo.infrastructure.repositories.ElementInfoRepository;
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
    @Autowired
    private ElementInfoRepository elementInfoRepository;

    public void addNewTaskToState(Long idProject,Long idContainer, Long idState, TaskCreatePayload payload){
        Project projectDB = projectRepository.findById(idProject).orElseThrow(); 

        Container containerOfProjectDB = projectDB.getContainer(); 

        Element stateDB = elementRepository.findById(idState).orElseThrow(); 

        List<Element> states = containerOfProjectDB.getElements(); 

        containerOfProjectDB.setElements(findState(states, stateDB, payload));
        
        projectDB.setContainer(containerOfProjectDB);

        containerRepository.save(containerOfProjectDB);

        projectRepository.save(projectDB);

    }
    public void taskChangeOfState(Long idProject, Long idContainer, Long idStateFrom, Long idStateTo, Long idTask ){
        Project projectDB = projectRepository.findById(idProject).orElseThrow(); 

        Container containerOfProjectDB = projectDB.getContainer(); 

        Element taskDB = elementRepository.findById(idTask).orElseThrow();

        List<Element> actualizedStates = moveTask(containerOfProjectDB.getElements(), taskDB, idStateFrom, idStateTo);

        containerOfProjectDB.setElements(actualizedStates);

        projectDB.setContainer(containerOfProjectDB);

        containerRepository.save(containerOfProjectDB);

        projectRepository.save(projectDB);

    }
    private List<Element> moveTask(List<Element> states, Element task, Long idStateFrom, Long idStateTo){

        Element stateFromDB = elementRepository.findById(idStateFrom).orElseThrow();

        List<Element> tasksStateFrom = stateFromDB.getSubElements();
        
        tasksStateFrom.removeIf(taskSt -> taskSt.equals(task));

        for (Element state : states) {

            if(state.getId()==idStateFrom){
                 state.setSubElements(tasksStateFrom);
                }

            if(state.getId()==idStateTo){
                List<Element> tasksStateTo = state.getSubElements();

                tasksStateTo.add(task);

                state.setSubElements(tasksStateTo);
            }
        }

        return states;
    }
    private List<Element> findState(List<Element> states, Element StateToFind, TaskCreatePayload payload){

        TypeOfElement type = typeOfElementRepository.findByName(payload.getTypeElement()).orElseThrow();
        List<ElementInfo> info = new ArrayList<>();
        ElementInfo descriptionTask = new ElementInfo(null, payload.getDescription());
        elementInfoRepository.save(descriptionTask);
        info.add(descriptionTask);
        Element taskToAdd = new Element(null, payload.getName(), false, payload.getColor(), payload.getFontColor(), null, info, type);

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
