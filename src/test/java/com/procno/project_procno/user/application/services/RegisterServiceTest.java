package com.procno.project_procno.user.application.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.procno.project_procno.role.domain.models.Role;
import com.procno.project_procno.user.domain.models.User;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {

    @InjectMocks
    RegisterService service;

    @Mock
    UserRepository repository;

    @Test
    void testStore() {
        Set<Role> roles = new HashSet<>();
        Role role = new Role(1L, "ROLE_USER");

        roles.add(role);

        User user = new User(1L, "user", "1234", "user@mail.com", roles);

        when(repository.save(user)).thenReturn(user);

        User userStore = repository.save(user);

        assertThat(userStore, is(notNullValue(null)));
        assertThat(userStore.getUsername(), is("user"));
        assertThat(userStore.getPassword(), is("1234"));
        assertThat(userStore.getEmail(), is("user@mail.com"));
        assertThat(userStore.getRoles().size(), is(equalTo(1)));


    }
}
