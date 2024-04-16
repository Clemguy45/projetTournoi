package com.example.servicejeux.service;

import com.example.servicejeux.dtos.JeuxDTO;
import com.example.servicejeux.entities.Jeux;
import com.example.servicejeux.exception.JeuDejaExistantException;
import com.example.servicejeux.exception.JeuInexistantException;

import java.util.List;

public interface JeuxFacade {
    Jeux createJeux(JeuxDTO jeuxDTO) throws JeuDejaExistantException;
    Jeux updateJeux(String titre,JeuxDTO jeuxDTO) throws JeuInexistantException;
    void deleteJeux(String titre);
    Jeux getJeux(String titre);
    List <Jeux> getAllJeux();
}
