package com.procno.project_procno.element.domain.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class TaskCreatePayload {
    private String name;
    private String description;
    private String typeElement;
    private String color;
    private String fontColor;
}
