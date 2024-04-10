package com.example.facade;

import com.example.entities.Tournoi;
import com.example.dto.TournoiDTO;
import com.example.exception.TournoiDejaExistantException;
import com.example.exception.TournoiNonExixtantException;
import com.example.repository.TournoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournoiFacadeImpl implements TournoiFacade{

    private final TournoiRepository tournoiRepository;

    @Autowired
    public TournoiFacadeImpl(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    @Override
    public List<Tournoi> getAllTournois() {
        return tournoiRepository.findAll();
    }

    @Override
    public Tournoi getTournoiByName(String tournoiName) {
        return tournoiRepository.findByName(tournoiName);
    }

    @Override
    public void suprimerTournoi(String tournoiName) {
        Tournoi tournoi = tournoiRepository.findByName(tournoiName);
        tournoiRepository.deleteById(tournoi.getId());
    }

    @Override
    public Tournoi modifierTournoi(String name,TournoiDTO modifiedTournoi) throws TournoiNonExixtantException {
        Tournoi tournoi = tournoiRepository.findByName(name);
        if (!tournoiRepository.existsByName(tournoi.getNomTournoi())){
            throw new TournoiNonExixtantException();
        }
        tournoi.setNomTournoi(modifiedTournoi.nomTournoi());
        tournoi.setOrganisation(modifiedTournoi.organisation());
        tournoi.setResponsable(modifiedTournoi.responsable());
        tournoi.setDate(modifiedTournoi.date());
        tournoi.setIdJeu(modifiedTournoi.idJeu());
        tournoi.setJoueursIds(modifiedTournoi.joueursIds());
        tournoi.setEquipesIds(modifiedTournoi.equipesIds());
        tournoi.setRegles(modifiedTournoi.regles());

        tournoiRepository.save(tournoi);
        return tournoi;
    }

    @Override
    public Tournoi createTournoi(TournoiDTO newTournoi) throws TournoiDejaExistantException {
        Tournoi tournoi = new Tournoi();
        if (tournoiRepository.existsByName(newTournoi.nomTournoi())){
            throw new TournoiDejaExistantException();
        }
        tournoi.setNomTournoi(newTournoi.nomTournoi());
        tournoi.setOrganisation(newTournoi.organisation());
        tournoi.setResponsable(newTournoi.responsable());
        tournoi.setDate(newTournoi.date());
        tournoi.setIdJeu(newTournoi.idJeu());
        tournoi.setJoueursIds(newTournoi.joueursIds());
        tournoi.setEquipesIds(newTournoi.equipesIds());
        tournoi.setRegles(newTournoi.regles());

        tournoiRepository.save(tournoi);
        return tournoi;
    }
}
