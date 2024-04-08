package com.example.servicejoueur.service;

import com.example.servicejoueur.dto.RegisterDTO;
import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.exception.CompteDejaExistant;
import com.example.servicejoueur.exception.PseudoDejaPrisException;

public interface JoueurService {
    Joueur register(RegisterDTO registerDTO) throws PseudoDejaPrisException, CompteDejaExistant;
    boolean existByEmail(String email);
    boolean existByPseudo(String username);
}
