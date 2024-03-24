package com.example.Classe;

import java.util.Date;
import java.util.List;

public class Tournoi {
    private Long id;
    private String jeu;
    private String responsable;
    private String organisation;
    private List<Long> joueursIds; // Liste des identifiants des joueurs inscrits
    private List<Long> equipesIds; // Liste des identifiants des équipes inscrites
    private List<String> règles;
    private Date date;
    private int horaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJeu() {
        return jeu;
    }

    public void setJeu(String jeu) {
        this.jeu = jeu;
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

    public List<Long> getEquipesIds() {
        return equipesIds;
    }

    public void setEquipesIds(List<Long> equipesIds) {
        this.equipesIds = equipesIds;
    }

    public List<String> getRègles() {
        return règles;
    }

    public void setRègles(List<String> règles) {
        this.règles = règles;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHoraire() {
        return horaire;
    }

    public void setHoraire(int horaire) {
        this.horaire = horaire;
    }
}
