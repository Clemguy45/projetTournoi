package com.example.servicejoueur.entities;

import com.example.servicejoueur.enums.JoueurRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Getter
@Setter
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private boolean emailVerified = true;
    private boolean enabled = true;
    private String first_name;
    private String last_name;
    private String realm_id = "joueur";
    private String pseudo;
    private LocalDateTime created_at = LocalDateTime.now();
    @ElementCollection
    private List<String> jeux = new ArrayList<>();
    private String biographie;
    private String password;
    private JoueurRole role;
}
