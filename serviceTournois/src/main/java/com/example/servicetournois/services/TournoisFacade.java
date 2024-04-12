package com.example.servicetournois.services;

import com.example.servicetournois.dto.TournoisDTO;
import com.example.servicetournois.entities.Tournois;
import com.example.servicetournois.exception.TournoisDejaExistantException;
import com.example.servicetournois.exception.TournoisNonExistantException;

import java.util.List;

public interface TournoisFacade {
    Tournois createdTournois (TournoisDTO tournoisDTO) throws TournoisDejaExistantException;
    Tournois updatedTournois (TournoisDTO tournoisDTO) throws TournoisNonExistantException;
    void deleteTournois (String nomTournois);
    Tournois getTournoisById (String nomTournois) throws TournoisNonExistantException;
    List<Tournois> getAllTournois ();
}
