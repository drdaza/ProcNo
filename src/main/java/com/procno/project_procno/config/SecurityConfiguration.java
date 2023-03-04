package com.procno.project_procno.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.procno.project_procno.user.application.detailsService.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    MyAuthenticationEntryPoint authenticationEntryPoint;

    JpaUserDetailsService service;

    public SecurityConfiguration(JpaUserDetailsService service) {
        this.service = service;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .cors()
            .and()
            .headers(header -> header.frameOptions().sameOrigin())
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .logout(out -> out
                    .logoutUrl("/api/logout")
                    .deleteCookies("JSESSIONID"))
            .authorizeRequests(auth -> auth
                    .antMatchers("api/register").permitAll()
                    .antMatchers("/api/login").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/templates/delete").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated())
            .userDetailsService(service)
            .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
            .httpBasic(basic -> basic
                    .authenticationEntryPoint(authenticationEntryPoint))
            .httpBasic(Customizer.withDefaults());   
                
        return http.build();
    }
}
