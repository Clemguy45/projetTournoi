package com.example.controller;

import com.example.entities.Tournoi;
import com.example.dto.TournoiDTO;
import com.example.exception.TournoiDejaExistantException;
import com.example.exception.TournoiNonExixtantException;
import com.example.facade.TournoiFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournoi")
public class TournoiControleur {

    private final TournoiFacadeImpl tournoiFacade;

    @Autowired
    public TournoiControleur(TournoiFacadeImpl tournoiFacade) {
        this.tournoiFacade = tournoiFacade;
    }

    @GetMapping
    public ResponseEntity<?> getAllTournois() {
        List<Tournoi> tournois = tournoiFacade.getAllTournois();
        return new ResponseEntity<>(tournois, HttpStatus.OK);
    }

    @GetMapping("/{nom}")
    public ResponseEntity<?> getTournoiByName(@PathVariable("nom") String nom) {
        Tournoi tournoi = tournoiFacade.getTournoiByName(nom);
        if (tournoi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tournoi, HttpStatus.OK);
    }

    @PostMapping("/creer")
    public ResponseEntity<?> createTournoi(@RequestBody TournoiDTO newTournoi) {
        try {
            Tournoi tournoi = tournoiFacade.createTournoi(newTournoi);
            return new ResponseEntity<>(tournoi, HttpStatus.CREATED);
        } catch (TournoiDejaExistantException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/modifier/{nom}")
    public ResponseEntity<?> modifierTournoi(@PathVariable String nom, @RequestBody TournoiDTO modifiedTournoi) {
        try {
            Tournoi tournoi = tournoiFacade.modifierTournoi(nom, modifiedTournoi);
            return new ResponseEntity<>(tournoi, HttpStatus.OK);
        } catch (TournoiNonExixtantException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/supprimer/{nom}")
    public ResponseEntity<?> supprimerTournoi(@PathVariable("nom") String nom) {
        try {
            tournoiFacade.suprimerTournoi(nom);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
