package com.procno.project_procno.project.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.procno.project_procno.container.domain.models.Container;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_project")
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @OneToOne
    private Container container;
    
    public Project() {
    }

    public Project(Long id, String title, String description, Container container) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.container = container;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
    
    
}
