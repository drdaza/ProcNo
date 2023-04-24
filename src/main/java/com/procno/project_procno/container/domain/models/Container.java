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
import javax.persistence.Table;

import com.procno.project_procno.element.domain.models.Element;
import com.procno.project_procno.typeOfContainer.domain.models.TypeOfContainer;

@Entity
@Table(name = "containers")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_container")
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "container_has_elements",
    joinColumns = @JoinColumn(name = "container_id"),
    inverseJoinColumns = @JoinColumn(name = "element_id"))
    private List<Element> elements;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "containers_types_of_containers",
    joinColumns = @JoinColumn(name = "container_id"),
    inverseJoinColumns = @JoinColumn(name = "type_container_id"))
    private List<TypeOfContainer> types;

    public Container() {
    }

    public Container(Long id, String name, List<Element> elements, List<TypeOfContainer> types) {
        this.id = id;
        this.name = name;
        this.types = types;
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


    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<TypeOfContainer> getTypes() {
        return types;
    }

    public void setTypes(List<TypeOfContainer> types) {
        this.types = types;
    }

    
}
