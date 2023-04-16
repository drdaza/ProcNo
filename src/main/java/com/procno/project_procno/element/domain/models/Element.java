package com.procno.project_procno.element.domain.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.procno.project_procno.complexElement.domain.models.ComplexElement;
import com.procno.project_procno.container.domain.models.Container;

@Entity
@Table(name = "elements")
@Inheritance(strategy = InheritanceType.JOINED)
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_element")
    private Long id;
    private String name;
    private Boolean bold;
    private String color;
    private String fontColor;
    @ManyToMany(mappedBy = "elements")
    private List<Container> containers;
    @ManyToMany(mappedBy = "simpleElements")
    private List<ComplexElement> complexElements;

    public Element() {
    }

    public Element(Long id, String name) {
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

    public Boolean getBold() {
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    

}
