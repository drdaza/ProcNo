package com.procno.project_procno.role.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.role.domain.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
