package com.example.servicejoueur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joueur")
public class JoueurControlleur {

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok().build();
    }
}
