package com.procno.project_procno.elemetInfo.domain.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.procno.project_procno.element.domain.models.Element;

@Entity
@Table(name = "elements_infos")
public class ElementInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info_element")
    private Long id;
    private String content;
    @ManyToMany(mappedBy = "info")
    private List<Element> elements;
   
    public ElementInfo() {
    }

     public ElementInfo(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
}
