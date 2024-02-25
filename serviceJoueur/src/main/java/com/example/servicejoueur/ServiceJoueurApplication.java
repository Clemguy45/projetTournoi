package com.example.servicejoueur;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class ServiceJoueurApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJoueurApplication.class, args);
    }

}
