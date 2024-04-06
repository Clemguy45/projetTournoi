package com.example.Controleur;

import com.example.Classe.Tournoi;
import com.example.facade.TournoiFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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


    @GetMapping("/{id}")
    public Tournoi obtenirTournoi(@PathVariable("id") Long id) {
        return tournoiFacade.obtenirTournoi(id);
    }

    @GetMapping("/liste")
    public List<Tournoi> listeTournois() {
        return tournoiFacade.listeTournois();
    }

    @GetMapping("/{id}/IdJeu")
    public Long getIdJeu(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getJeu(tournoi);
    }
    @GetMapping("/{id}/responsable")
    public String getResponsable(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getResponsable(tournoi);
    }@GetMapping("/{id}/organisation")
    public String getOrganisation(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getOrganisation(tournoi);
    }@GetMapping("/{id}/joueursIds")
    public List<Long> getJoueursIds(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getJoueursIds(tournoi);
    }@GetMapping("/{id}/equipesId")
    public List<Long> getEquipesIds(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getEquipesIds(tournoi);
    }@GetMapping("/{id}/règles")
    public List<String> getRègles(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getRègles(tournoi);
    }@GetMapping("/{id}/date")
    public Date getDate(@PathVariable("id") Long id){
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.getDate(tournoi);
    }

    @PutMapping("/{id}/modifierJeu")
    public String modifierJeuTournoi(@PathVariable("id") Long id, @RequestParam("idJeu") Long idJeu) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierJeu(tournoi, idJeu);
    }
    @PutMapping("/{id}/modifierResponsable")
    public String modifierResponsable(@PathVariable("id") Long id, @RequestParam("responsable") String responsable) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierResponsable(tournoi, responsable);
    }
    @PutMapping("/{id}/modifierOrganisation")
    public String modifierOrganisation(@PathVariable("id") Long id, @RequestParam("organisation") String organisation) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierOrganisation(tournoi, organisation);
    }
    @PutMapping("/{id}/modifierJoueursIds")
    public String modifierJoueursIds(@PathVariable("id") Long id, @RequestParam("JoueursIds") List<Long> joueursIds) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierJoueursIds(tournoi, joueursIds);
    }
    @PutMapping("/{id}/modifierEquipesIds")
    public String modifierEquipesIds(@PathVariable("id") Long id, @RequestParam("EquipesIds") List<Long> equipesIds) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierEquipesIds(tournoi, equipesIds);
    }
    @PutMapping("/{id}/modifierRègles")
    public String modifierRègles(@PathVariable("id") Long id, @RequestParam("règles") List<String> règles) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierRègles(tournoi, règles);
    }
    @PutMapping("/{id}/modifierDate")
    public String modifierDate(@PathVariable("id") Long id, @RequestParam("date") Date date) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.modifierDate(tournoi, date);
    }
    @PatchMapping("/{id}/ajouterJoueurId")
    public String ajouterJoueurId(@PathVariable("id") Long id, @RequestParam("joueurId") Long joueurId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.ajouterJoueurId(tournoi,joueurId);
    }
    @PatchMapping("/{id}/ajouterEquipeId")
    public String ajouterEquipeId(@PathVariable("id") Long id, @RequestParam("equipeId") Long equipeId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.ajouterEquipeId(tournoi,equipeId);
    }
    @PatchMapping("/{id}/ajouterRègle")
    public String ajouterRègle(@PathVariable("id") Long id, @RequestParam("regle") String règle) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.ajouterRègles(tournoi,règle);
    }
    @DeleteMapping("/{id}/supprimerJoueurId")
    public String supprimerJoueurId(@PathVariable("id") Long id, @RequestParam("joueurId") Long joueurId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.supprimerJoueurId(tournoi,joueurId);
    }
    @DeleteMapping("/{id}/supprimerEquipeId")
    public String supprimerEquipeId(@PathVariable("id") Long id, @RequestParam("equipeId") Long equipeId) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.supprimerEquipeId(tournoi,equipeId);
    }
    @DeleteMapping("/{id}/SupprimerRègleNum")
    public String supprimerRègleNum(@PathVariable("id") Long id, @RequestParam("index") int index) {
        Tournoi tournoi =  tournoiFacade.obtenirTournoi(id);
        return tournoiFacade.supprimerRègleNum(tournoi,index);
    }
}
