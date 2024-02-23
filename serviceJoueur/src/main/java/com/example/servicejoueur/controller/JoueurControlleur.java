package com.example.servicejoueur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/joueur")
public class JoueurControlleur {
    @GetMapping("/hello")
    public String hello (){
         return "ça marche";
    }
}
