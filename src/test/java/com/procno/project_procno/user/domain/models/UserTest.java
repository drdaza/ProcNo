package com.procno.project_procno.user.domain.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.procno.project_procno.role.domain.models.Role;
import com.procno.project_procno.role.infrastructure.repositories.RoleRepository;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void userHaveRoles(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("12345");

        Role role = new Role(null, "ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user= new User(null, "user", "user@mail.com", password, roles);

        roleRepository.save(role);
        userRepository.save(user);

        User userDB = entityManager.find(User.class, user.getId());

        assertThat("role", userDB.getId(), is(equalTo(1L)));
        assertThat("user role", userDB.getRoles().size(), is(equalTo(1)));
        assertThat("user role name", userDB.getRoles().contains(role));
    }
}
