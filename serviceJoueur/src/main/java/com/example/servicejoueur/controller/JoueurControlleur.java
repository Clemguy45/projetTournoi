package com.example.servicejoueur.controller;

import com.example.servicejoueur.dto.RegisterDTO;
import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.exception.CompteDejaExistant;
import com.example.servicejoueur.exception.PseudoDejaPrisException;
import com.example.servicejoueur.service.JoueurService;
import com.example.servicejoueur.service.JoueurServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/joueur")
public class JoueurControlleur {

    private JoueurService joueurService;

    public JoueurControlleur(JoueurServiceImpl joueurService, BCryptPasswordEncoder passwordEncoder){
        this.joueurService = joueurService;
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello2")
    public ResponseEntity hello2(){ return ResponseEntity.ok().build();}

    @PostMapping("/register")
    public ResponseEntity<Joueur> register(RegisterDTO joueurDTO){
        Joueur joueur;
        try {
            joueur = this.joueurService.register(joueurDTO.first_name(), joueurDTO.last_name(), joueurDTO.email(),
                    joueurDTO.password(), joueurDTO.pseudo(),joueurDTO.biographie());
        } catch (PseudoDejaPrisException | CompteDejaExistant p){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(joueur,OK);
    }
}
