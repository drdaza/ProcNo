package com.procno.project_procno.container.domain.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.project.domain.models.Project;

@Entity
@Table(name = "containers")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_container")
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Project> projects;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "container_has_elements",
    joinColumns = @JoinColumn(name = "container_id"),
    inverseJoinColumns = @JoinColumn(name = "element_id"))
    private List<Element> elements;

    public Container() {
    }

    public Container(Long id, String name, List<Project> projects, List<Element> elements) {
        this.id = id;
        this.name = name;
        this.projects = projects;
        this.elements = elements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

}
