package com.example.Controleur;

import com.example.Classe.Tournoi;
import com.example.facade.TournoiFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/creer")
    public String creerTournoi(@RequestBody Tournoi tournoi) {
        return tournoiFacade.creerTournoi(tournoi);
    }

    @PutMapping("/{id}")
    public String modifierTournoi(@PathVariable("id") Long id, @RequestBody Tournoi tournoi) {
        return tournoiFacade.modifierTournoi(id, tournoi);
    }

    @GetMapping("/{id}")
    public Tournoi obtenirTournoi(@PathVariable("id") Long id) {
        return tournoiFacade.obtenirTournoi(id);
    }

    @GetMapping("/liste")
    public List<Tournoi> listeTournois() {
        return tournoiFacade.listeTournois();
    }
}
