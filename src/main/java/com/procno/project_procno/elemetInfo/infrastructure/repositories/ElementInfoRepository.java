package com.procno.project_procno.elemetInfo.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.elemetInfo.domain.models.ElementInfo;

public interface ElementInfoRepository extends JpaRepository<ElementInfo, Long> {
    
}
