package com.procno.project_procno.element.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.element.domain.models.Element;

public interface ElementRepository extends JpaRepository<Element, Long>{
    public Optional<Element> findByName(String name);
}
