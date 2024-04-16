package com.example.servicejeux.controller;

import com.example.servicejeux.dtos.JeuxDTO;
import com.example.servicejeux.entities.Jeux;
import com.example.servicejeux.exception.JeuDejaExistantException;
import com.example.servicejeux.exception.JeuInexistantException;
import com.example.servicejeux.service.JeuxFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jeux")
public class JeuxController {
    private final JeuxFacade jeuxFacade;

    @Autowired
    public JeuxController(JeuxFacade jeuxFacade) {
        this.jeuxFacade = jeuxFacade;
    }

    @PostMapping("/create")
    public ResponseEntity<Jeux> createJeux(@RequestBody JeuxDTO jeuxDTO) {
        try {
            Jeux createdJeux = jeuxFacade.createJeux(jeuxDTO);
            return new ResponseEntity<>(createdJeux, HttpStatus.CREATED);
        } catch (JeuDejaExistantException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{titre}/update")
    public ResponseEntity<Jeux> updateJeux(@PathVariable String titre, @RequestBody JeuxDTO jeuxDTO) {
        try {
            Jeux updatedJeux = jeuxFacade.updateJeux(titre, jeuxDTO);
            return new ResponseEntity<>(updatedJeux, HttpStatus.OK);
        } catch (JeuInexistantException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleted/{titre}")
    public ResponseEntity<?> deleteJeux(@PathVariable String titre) {
        jeuxFacade.deleteJeux(titre);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{titre}")
    public ResponseEntity<Jeux> getJeux(@PathVariable String titre) {
        Jeux jeux = jeuxFacade.getJeux(titre);
        if (jeux != null) {
            return new ResponseEntity<>(jeux, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Jeux>> getAllJeux() {
        List<Jeux> jeuxList = jeuxFacade.getAllJeux();
        return new ResponseEntity<>(jeuxList, HttpStatus.OK);
    }
}
