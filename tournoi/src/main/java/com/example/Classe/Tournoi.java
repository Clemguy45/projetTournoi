package com.example.Classe;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Tournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long IdJeu;
    private String responsable;
    private String organisation;
    @ElementCollection
    private List<Long> joueursIds; // Liste des identifiants des joueurs inscrits
    @ElementCollection
    private List<Long> equipesIds; // Liste des identifiants des équipes inscrites
    @ElementCollection
    private List<String> regles;
    private Date date;

    public Tournoi() {
    }

    public Tournoi(Long id, Long idJeu, String responsable, String organisation, List<Long> joueursIds, List<Long> equipesIds, List<String> regles, Date date) {
        this.id = id;
        this.IdJeu = idJeu;
        this.responsable = responsable;
        this.organisation = organisation;
        this.joueursIds = joueursIds;
        this.equipesIds = equipesIds;
        this.regles = regles;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdJeu() {
        return IdJeu;
    }

    public void setIdJeu(Long idJeu) {
        IdJeu = idJeu;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public List<Long> getJoueursIds() {
        return joueursIds;
    }

    public void setJoueursIds(List<Long> joueursIds) {
        this.joueursIds = joueursIds;
    }

    public void addJoueurId(Long id){this.joueursIds.add(id);}

    public void supprimerJoueurId(Long id){
        if (joueursIds.contains(id)){
            this.joueursIds.remove(id);
            }
        }

    public List<Long> getEquipesIds() {
        return equipesIds;
    }

    public void setEquipesIds(List<Long> equipesIds) {
        this.equipesIds = equipesIds;
    }

    public void addEquipeId(Long id){this.equipesIds.add(id);}

    public void supprimerEquipeId(Long id){
        if (equipesIds.contains(id)){
            this.equipesIds.remove(id);
        }
    }

    public List<String> getRegles() {
        return regles;
    }

    public void setRegles(List<String> regles) {
        this.regles = regles;
    }

    public void addRegles(String regle){this.regles.add(regle);}

    public void supprimerRegleNum(int index){
        if (index >= 0 && index < regles.size()) {
            this.regles.remove(index);
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
