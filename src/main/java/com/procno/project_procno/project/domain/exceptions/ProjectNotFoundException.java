package com.procno.project_procno.project.domain.exceptions;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(String message){
        super(message);
    }
}
