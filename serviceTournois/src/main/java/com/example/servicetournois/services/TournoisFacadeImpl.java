package com.example.servicetournois.services;

import com.example.servicetournois.dto.TournoisDTO;
import com.example.servicetournois.entities.Tournois;
import com.example.servicetournois.exception.TournoisDejaExistantException;
import com.example.servicetournois.exception.TournoisNonExistantException;
import com.example.servicetournois.repository.TournoisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournoisFacadeImpl implements TournoisFacade{

    private TournoisRepository tournoisRepository;

    @Autowired
    public TournoisFacadeImpl(TournoisRepository tournoisRepository) {
        this.tournoisRepository = tournoisRepository;
    }

    @Override
    public Tournois createdTournois(TournoisDTO tournoisDTO) throws TournoisDejaExistantException {
        Tournois tournois = new Tournois();
        if (tournoisRepository.existsByNomTournoi(tournoisDTO.nomTournoi())) {
            throw new TournoisDejaExistantException();
        }
        tournois.setNomTournoi(tournoisDTO.nomTournoi());
        tournois.setOrganisation(tournoisDTO.organisation());
        tournois.setResponsable(tournoisDTO.responsable());
        tournois.setDate(tournoisDTO.date());
        tournois.setJoueursIds(tournoisDTO.joueursIds());
        tournois.setEquipesIds(tournoisDTO.equipesIds());
        tournois.setRegles(tournoisDTO.regles());
        tournois.setIdJeu(tournoisDTO.idJeu());

        tournoisRepository.save(tournois);

        return tournois;
    }

    @Override
    public Tournois updatedTournois(TournoisDTO tournoisDTO) throws TournoisNonExistantException {
        Tournois tournois = new Tournois();
        if (tournoisRepository.existsByNomTournoi(tournoisDTO.nomTournoi())) {
            throw new TournoisNonExistantException();
        }
        tournois.setNomTournoi(tournoisDTO.nomTournoi());
        tournois.setOrganisation(tournoisDTO.organisation());
        tournois.setResponsable(tournoisDTO.responsable());
        tournois.setDate(tournoisDTO.date());
        tournois.setJoueursIds(tournoisDTO.joueursIds());
        tournois.setEquipesIds(tournoisDTO.equipesIds());
        tournois.setRegles(tournoisDTO.regles());
        tournois.setIdJeu(tournoisDTO.idJeu());

        tournoisRepository.save(tournois);

        return tournois;
    }

    @Override
    public void deleteTournois(String nomTournois) {
        Tournois tournois = tournoisRepository.findByNomTournoi(nomTournois);
        tournoisRepository.delete(tournois);
    }

    @Override
    public Tournois getTournoisById(String nomTournois) throws TournoisNonExistantException {
        Tournois tournois = tournoisRepository.findByNomTournoi(nomTournois);
        if (tournois != null) {
            return tournois;
        }
        throw new TournoisNonExistantException();
    }

    @Override
    public List<Tournois> getAllTournois() {
        return tournoisRepository.findAll();
    }
}
