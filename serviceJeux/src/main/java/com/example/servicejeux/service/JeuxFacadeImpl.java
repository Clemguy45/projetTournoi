package com.example.servicejeux.service;

import com.example.servicejeux.dtos.JeuxDTO;
import com.example.servicejeux.entities.Jeux;
import com.example.servicejeux.exception.JeuDejaExistantException;
import com.example.servicejeux.exception.JeuInexistantException;
import com.example.servicejeux.repository.JeuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuxFacadeImpl implements JeuxFacade {

    private JeuxRepository jeuxRepository;

    @Autowired
    public JeuxFacadeImpl(JeuxRepository jeuxRepository) {
        this.jeuxRepository = jeuxRepository;
    }

    @Override
    public Jeux createJeux(JeuxDTO jeuxDTO) throws JeuDejaExistantException {
        Jeux jeux = new Jeux();
        if (jeuxRepository.existsByTitre(jeuxDTO.titre())){
            throw new JeuDejaExistantException();
        }
        jeux.setTitre(jeuxDTO.titre());
        jeux.setType(jeuxDTO.type());
        jeux.setPegi(jeuxDTO.pegi());
        jeux.setRangs(jeuxDTO.rangs());
        jeux.setNombreMaxJoueurs(jeuxDTO.nombreMaxJoueurs());
        jeux.setModesDeJeu(jeuxDTO.modesDeJeu());
        jeux.setTypeTournoi(jeuxDTO.typeTournoi());

        jeuxRepository.save(jeux);
        return jeux;

    }

    @Override
    public Jeux updateJeux(String titre, JeuxDTO jeuxDTO) throws JeuInexistantException {
        Jeux jeux = jeuxRepository.findByTitre(titre);
        if (!jeuxRepository.existsByTitre(titre)){
            throw new JeuInexistantException();
        }
        jeux.setTitre(jeuxDTO.titre());
        jeux.setType(jeuxDTO.type());
        jeux.setPegi(jeuxDTO.pegi());
        jeux.setRangs(jeuxDTO.rangs());
        jeux.setNombreMaxJoueurs(jeuxDTO.nombreMaxJoueurs());
        jeux.setModesDeJeu(jeuxDTO.modesDeJeu());
        jeux.setTypeTournoi(jeuxDTO.typeTournoi());

        jeuxRepository.save(jeux);
        return jeux;
    }


    @Override
    public void deleteJeux(String titre) {
        Jeux jeux = jeuxRepository.findByTitre(titre);
        jeuxRepository.deleteById(jeux.getId());
    }

    @Override
    public Jeux getJeux(String titre) {
        return jeuxRepository.findByTitre(titre);
    }

    @Override
    public List<Jeux> getAllJeux() {
        return jeuxRepository.findAll();
    }
}
