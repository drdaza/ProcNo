package com.procno.project_procno.user.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.user.domain.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByUsername(String username);
}
