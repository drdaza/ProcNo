package com.procno.project_procno.interfaces.services;

import org.springframework.stereotype.Service;

@Service
public interface BasicService<T,P> {
    
    public T getOne(P id);
    public T save(T entity);
}
