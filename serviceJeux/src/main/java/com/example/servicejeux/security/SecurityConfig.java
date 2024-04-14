package com.example.servicejeux.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests( registry -> registry
                        .requestMatchers(HttpMethod.GET, "/jeux/**", "/actuator/health").permitAll()
                        .requestMatchers(HttpMethod.POST, "/jeux/create").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/jeux/deleted/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/jeux/**").permitAll()
                        .anyRequest().authenticated()
                ).csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}