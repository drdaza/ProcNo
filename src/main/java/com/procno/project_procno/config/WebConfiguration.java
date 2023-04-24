package com.procno.project_procno.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        registry
        .addMapping("/**")
        .allowedOrigins("http://localhost:5173")
        .allowCredentials(true)
        .allowedMethods("GET","POST","PUT","DELETE","OPTION");
    }
    
}
