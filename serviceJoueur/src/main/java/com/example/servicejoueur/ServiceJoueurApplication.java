package com.example.servicejoueur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class ServiceJoueurApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJoueurApplication.class, args);
    }

}
