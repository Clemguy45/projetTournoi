package com.example.servicetournois.repository;

import com.example.servicetournois.entities.Tournois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournoisRepository extends JpaRepository<Tournois, Long> {
    Tournois findByNomTournoi(String nomTournoi);
    boolean existsByNomTournoi(String nomTournoi);
}
