package com.example.servicejoueur.service;

import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.exception.CompteDejaExistant;
import com.example.servicejoueur.exception.PseudoDejaPrisException;

public interface JoueurService {
    Joueur register(String first_name, String last_name,
                    String email, String password,
                    String user_name, String biographie) throws PseudoDejaPrisException, CompteDejaExistant;
}
