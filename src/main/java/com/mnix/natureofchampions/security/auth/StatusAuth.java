package com.mnix.natureofchampions.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class StatusAuth {
    @Value("${management.security.username}")
    private String username;

    @Value("${management.security.password}")
    private String password;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(username).password(password).roles("ACTUATOR");
    }
}
