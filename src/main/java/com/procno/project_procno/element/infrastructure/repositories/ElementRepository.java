package com.procno.project_procno.element.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.element.domain.models.Element;

public interface ElementRepository<T extends Element> extends JpaRepository<T, Long>{
    public Optional<T> findByName(String name);
}
