package com.example.facade;


import com.example.entities.Tournoi;
import com.example.dto.TournoiDTO;
import com.example.exception.TournoiDejaExistantException;
import com.example.exception.TournoiNonExixtantException;

import java.util.List;

public interface TournoiFacade {
    List<Tournoi> getAllTournois();
    Tournoi getTournoiByName(String tournoiName);
    void suprimerTournoi(String tournoiName);
    Tournoi modifierTournoi(String name,TournoiDTO modifiedTournoi) throws TournoiNonExixtantException;
    Tournoi createTournoi(TournoiDTO newTournoi) throws TournoiDejaExistantException;


}
