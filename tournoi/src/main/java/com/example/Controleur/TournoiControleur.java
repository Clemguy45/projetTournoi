package com.example.Controleur;

import com.example.Classe.Tournoi;
import com.example.dto.ModifierDTO;
import com.example.dto.TournoiDTO;
import com.example.facade.TournoiFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/tournoi")
public class TournoiControleur {

    private final TournoiFacadeImpl tournoiFacade;

    @Autowired
    public TournoiControleur(TournoiFacadeImpl tournoiFacade) {
        this.tournoiFacade = tournoiFacade;
    }

    @PostMapping("/creer")
    public ResponseEntity creerTournoi(@RequestBody TournoiDTO tournoiDto) {
        Tournoi tournoi = tournoiFacade.creerTournoi(tournoiDto);
        return ResponseEntity.status(CREATED).body(tournoi);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenirTournoi(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tournoiFacade.obtenirTournoi(id));
    }

    @GetMapping("/liste")
    public ResponseEntity listeTournois() {
        return ResponseEntity.ok(tournoiFacade.listeTournois());
    }

    @GetMapping("/{id}/IdJeu")
    public ResponseEntity getIdJeu(@PathVariable("id") Long id){
        return ResponseEntity.ok(tournoiFacade.getIdJeu(id));
    }
    @GetMapping("/{id}/responsable")
    public String getResponsable(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getResponsable(id);
    }@GetMapping("/{id}/organisation")
    public String getOrganisation(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getOrganisation(id);
    }@GetMapping("/{id}/joueursIds")
    public List<Long> getJoueursIds(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getJoueursIds(id);
    }@GetMapping("/{id}/equipesId")
    public List<Long> getEquipesIds(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getEquipesIds(id);
    }@GetMapping("/{id}/règles")
    public List<String> getRègles(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getRegles(id);
    }@GetMapping("/{id}/date")
    public Date getDate(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getDate(id);
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity modifierTournoi(@PathVariable("id") Long id,@RequestBody ModifierDTO modifierDTO) {
        Tournoi tournoi = tournoiFacade.modifierTournoi(modifierDTO);
        return ResponseEntity.status(CREATED).body(tournoi);
    }

    @PatchMapping("/{id}/ajouterJoueurId")
    public String ajouterJoueurId(@PathVariable("id") Long id, @RequestParam("joueurId") Long joueurId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.ajouterJoueurId(id,joueurId);
    }
    @PatchMapping("/{id}/ajouterEquipeId")
    public String ajouterEquipeId(@PathVariable("id") Long id, @RequestParam("equipeId") Long equipeId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.ajouterEquipeId(id,equipeId);
    }
    @PatchMapping("/{id}/ajouterRègle")
    public String ajouterRègle(@PathVariable("id") Long id, @RequestParam("regle") String règle) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.ajouterRegles(id,règle);
    }
    @DeleteMapping("/{id}/supprimerJoueurId")
    public String supprimerJoueurId(@PathVariable("id") Long id, @RequestParam("joueurId") Long joueurId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.supprimerJoueurId(id,joueurId);
    }
    @DeleteMapping("/{id}/supprimerEquipeId")
    public String supprimerEquipeId(@PathVariable("id") Long id, @RequestParam("equipeId") Long equipeId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.supprimerEquipeId(id,equipeId);
    }
    @DeleteMapping("/{id}/SupprimerRègleNum")
    public String supprimerRegleNum(@PathVariable("id") Long id, @RequestParam("index") int index) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.supprimerRegleNum(id,index);
    }
}
