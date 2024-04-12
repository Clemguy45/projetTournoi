package com.example.servicetournois.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tournois")
@Data
@Getter
@Setter
public class Tournois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long IdJeu;
    private String nomTournoi;
    private String responsable;
    private String organisation;
    @ElementCollection
    private List<Long> joueursIds; // Liste des identifiants des joueurs inscrits
    @ElementCollection
    private List<Long> equipesIds; // Liste des identifiants des équipes inscrites
    @ElementCollection
    private List<String> regles;
    private Date date;
}
