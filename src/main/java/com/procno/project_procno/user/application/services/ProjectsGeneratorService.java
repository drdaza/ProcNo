package com.procno.project_procno.user.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procno.project_procno.container.domain.models.Container;
import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.element.infrastructure.repositories.ElementRepository;
import com.procno.project_procno.project.domain.models.Project;
import com.procno.project_procno.typeOfContainer.domain.models.TypeOfContainer;
import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;

@Service
public class ProjectsGeneratorService {

    @Autowired
    private static ElementRepository elementRepository;

    public static Project createWorkoutPlannerProject(Project projectTemplate){

        List<Element> elements = new ArrayList<>();

        TypeOfElement type = new TypeOfElement(4L,"box");

        Element elementDayOne = new Element(null, "Dia 1",false, "white", "black", new ArrayList<>(), null, type);
        Element elementDayTwo = new Element(null, "Dia 2",false, "white", "black", new ArrayList<>(), null, type);
        Element elementDayThree = new Element(null, "Dia 3",false, "white", "black", new ArrayList<>(), null, type);
        Element elementDayFour = new Element(null, "Dia 4",false, "white", "black", new ArrayList<>(), null, type);
        Element elementDayFive = new Element(null, "Dia 5",false, "white", "black", new ArrayList<>(), null, type);

        elementRepository.save(elementDayOne);
        elementRepository.save(elementDayTwo);
        elementRepository.save(elementDayThree);
        elementRepository.save(elementDayFour);
        elementRepository.save(elementDayFive);

        List<TypeOfContainer> typeOfContainer = new ArrayList<>();

        typeOfContainer.add(new TypeOfContainer(2L, "workout planner"));

        Container containerForProject = new Container(null, "container"+projectTemplate.getTitle(), elements, typeOfContainer);

        projectTemplate.setContainer(containerForProject);

        return projectTemplate;
    }
}
