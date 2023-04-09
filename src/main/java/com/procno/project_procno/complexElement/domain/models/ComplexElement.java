package com.procno.project_procno.complexElement.domain.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.procno.project_procno.element.domain.models.Element;

@Entity
@PrimaryKeyJoinColumn(name = "id_element")
public class ComplexElement extends Element {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "complex_element_has_elements",
    joinColumns = @JoinColumn(name = "complex_element_id"),
    inverseJoinColumns = @JoinColumn(name = "element_id"))
    private List<Element> elements;

    public ComplexElement(List<Element> elements) {
        this.elements = elements;
    }

    public ComplexElement(Long id, String name, List<Element> elements) {
        super(id, name);
        this.elements = elements;
    }

    @Override
    public Long getId() {

        return super.getId();
    }

    @Override
    public String getName() {

        return super.getName();
    }

}
