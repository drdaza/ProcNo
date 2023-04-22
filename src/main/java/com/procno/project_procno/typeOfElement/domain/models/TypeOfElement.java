package com.procno.project_procno.typeOfElement.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types_of_elements")
public class TypeOfElement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_element")
    private Long id;
    private String name;
    private Boolean bold;
    private String color;
    private String fontColor;
    public TypeOfElement() {
    }
   
    public TypeOfElement(Long id, String name, Boolean bold, String color, String fontColor) {
        this.id = id;
        this.name = name;
        this.bold = bold;
        this.color = color;
        this.fontColor = fontColor;
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
