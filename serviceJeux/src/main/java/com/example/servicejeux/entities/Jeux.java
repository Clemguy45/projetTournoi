package com.example.servicejeux.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "jeux")
@Getter
@Setter
public class Jeux {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String type;
    private int pegi;
    @ElementCollection
    private List<String> rangs;
    private int nombreMaxJoueurs;
    @ElementCollection
    private List<String> modesDeJeu;
    private String typeTournoi;
}
