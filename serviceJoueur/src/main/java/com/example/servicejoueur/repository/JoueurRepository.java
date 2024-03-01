package com.example.servicejoueur.repository;

import com.example.servicejoueur.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,String> {
    boolean existsJoueurByPseudo(String pseudo);
    boolean existsJoueurByEmail(String email);
}
