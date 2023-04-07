package com.procno.project_procno.interfaces.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AdminService<T, P> {
    public void delete(P id);
    public T update(P id, T entity);
    public List<T> listAll();
}
