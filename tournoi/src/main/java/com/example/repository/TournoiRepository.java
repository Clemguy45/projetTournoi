package com.example.repository;

import com.example.entities.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournoiRepository extends JpaRepository<Tournoi, Long> {
    // Méthodes supplémentaires peuvent être ajoutées ici si nécessaire
    Tournoi findByName(String name);
    boolean existsByName(String name);
}
