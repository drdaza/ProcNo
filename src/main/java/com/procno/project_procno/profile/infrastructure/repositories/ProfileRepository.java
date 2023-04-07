package com.procno.project_procno.profile.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.procno.project_procno.profile.domain.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
    
}
