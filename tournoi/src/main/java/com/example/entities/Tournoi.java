package com.example.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Tournois")
@Getter
@Setter
public class Tournoi {
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
