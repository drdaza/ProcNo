package com.procno.project_procno.user.application.detailsService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.procno.project_procno.user.domain.userDetails.SecurityUser;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

    private UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
               .map(SecurityUser::new)
               .orElseThrow(() -> new UsernameNotFoundException("username not found"+username)); 
    }
    
}
