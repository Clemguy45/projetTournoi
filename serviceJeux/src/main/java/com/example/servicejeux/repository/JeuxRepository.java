package com.example.servicejeux.repository;

import com.example.servicejeux.entities.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuxRepository extends JpaRepository <Jeux, Long> {

    Jeux findByTitre(String titre);
    boolean existsByTitre(String titre);
    void deleteById(Long id);

}
