package com.procno.project_procno.typeOfContainer.domain.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.procno.project_procno.container.domain.models.Container;

@Entity
@Table(name = "types_of_containers")
public class TypeOfContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_container")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "types")
    private List<Container> containers;

    public TypeOfContainer() {
    }

    public TypeOfContainer(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
