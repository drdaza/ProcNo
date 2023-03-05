package com.procno.project_procno.user.application.detailsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.procno.project_procno.role.domain.models.Role;
import com.procno.project_procno.user.domain.models.User;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class JpaUserDetailsServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    JpaUserDetailsService jpaUserDetailsService;

    @BeforeEach
    public void setup() {
        
    }

    @Test
    void testLoadUserByUsername() {

        String username = "user";

        Set<Role> roles = new HashSet<>();
        Role role = new Role(1L, "ROLE_USER");

        roles.add(role);

        User user = new User(1L, "user", "1234", "user@mail.com", roles);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserDetails userDetails = jpaUserDetailsService.loadUserByUsername(username);

        assertThat(userDetails, is(notNullValue(null)));
        assertThat(userDetails.getUsername(), is(username));
        assertThat(userDetails.getPassword(), is(equalTo("1234")));
        assertThat(userDetails.getAuthorities().size(), is(equalTo(1)));
        assertThat(userDetails.getAuthorities(), contains(authority));
    }
}
