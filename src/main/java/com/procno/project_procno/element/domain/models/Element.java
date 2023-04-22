package com.procno.project_procno.element.domain.models;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.procno.project_procno.container.domain.models.Container;
import com.procno.project_procno.elemetInfo.domain.models.ElementInfo;
import com.procno.project_procno.typeOfElement.domain.models.TypeOfElement;

@Entity
@Table(name = "elements")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_element")
    private Long id;
    private String name;
    @OneToOne()
    private TypeOfElement typeOfElement;
    @ManyToMany(mappedBy = "elements")
    private List<Container> containers;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "elements_has_subelements", joinColumns = @JoinColumn(name = "element_id"), inverseJoinColumns = @JoinColumn(name = "sub_element_id"))
    private List<Element> subElements;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "elements_has_info", joinColumns = @JoinColumn(name = "element_id"), inverseJoinColumns = @JoinColumn(name = "infot_id"))
    private List<ElementInfo> info;

    public Element() {
    }

    public Element(Long id, String name,List<Element> subElements,
            List<ElementInfo> info, TypeOfElement typeOfElement) {
        this.id = id;
        this.name = name;
        this.subElements = subElements;
        this.info = info;
        this.typeOfElement = typeOfElement;
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

    public List<Element> getSubElements() {
        return subElements;
    }

    public void setSubElements(List<Element> subElements) {
        this.subElements = subElements;
    }

    public List<ElementInfo> getInfo() {
        return info;
    }

    public void setInfo(List<ElementInfo> info) {
        this.info = info;
    }

    public TypeOfElement getTypeOfElement() {
        return typeOfElement;
    }

    public void setTypeOfElement(TypeOfElement typeOfElement) {
        this.typeOfElement = typeOfElement;
    }
    
}
