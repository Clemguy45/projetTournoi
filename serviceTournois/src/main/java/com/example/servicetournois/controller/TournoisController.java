package com.example.servicetournois.controller;

import com.example.servicetournois.dto.TournoisDTO;
import com.example.servicetournois.entities.Tournois;
import com.example.servicetournois.exception.TournoisDejaExistantException;
import com.example.servicetournois.exception.TournoisNonExistantException;
import com.example.servicetournois.services.TournoisFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournois")
public class TournoisController {

    private final TournoisFacade tournoisFacade;

    @Autowired
    public TournoisController(TournoisFacade tournoisFacade) {
        this.tournoisFacade = tournoisFacade;
    }


    @PostMapping("/create")
    public ResponseEntity<Tournois> createTournois(@RequestBody TournoisDTO tournoisDTO) throws TournoisDejaExistantException {
        try {
            Tournois tournois = tournoisFacade.createdTournois(tournoisDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(tournois);
        } catch (TournoisDejaExistantException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Tournois> updateTournois(@RequestBody TournoisDTO tournoisDTO) throws TournoisNonExistantException {
        try {
            Tournois tournois = tournoisFacade.updatedTournois(tournoisDTO);
            return ResponseEntity.ok(tournois);
        } catch (TournoisNonExistantException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{nomTournois}")
    public ResponseEntity<Void> deleteTournois(@PathVariable String nomTournois) {
        tournoisFacade.deleteTournois(nomTournois);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{nomTournois}")
    public ResponseEntity<Tournois> getTournoisById(@PathVariable String nomTournois) {
        try {
            Tournois tournois = tournoisFacade.getTournoisById(nomTournois);
            return ResponseEntity.ok(tournois);
        } catch (TournoisNonExistantException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tournois>> getAllTournois() {
        List<Tournois> tournoisList = tournoisFacade.getAllTournois();
        return ResponseEntity.ok(tournoisList);
    }
}
