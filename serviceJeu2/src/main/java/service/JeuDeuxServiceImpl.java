package service;

import exceptions.JeuDejaExistantException;
import modele.JeuDeux;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import repository.JeuDeuxRepository;

import java.util.List;

@Service
public class JeuDeuxServiceImpl implements JeuDeuxService {

    private final JeuDeuxRepository jeuDeuxRepository;



    @Autowired
    public JeuDeuxServiceImpl(JeuDeuxRepository jeuDeuxRepository){
        this.jeuDeuxRepository = jeuDeuxRepository;

    }

    @Override
    public void creerJeuDeux(String titre, String type, int pegi, List<String> rangsDisponibles, int nombreMaxJoueurs, List<String> modesDeJeu) throws JeuDejaExistantException {
        JeuDeux jeuDeux = new JeuDeux();

        if(jeuDeuxRepository.alreadyExistsJeuDeux(titre)){
            throw new JeuDejaExistantException();
        }
        jeuDeux.setId(jeuDeux.getId());
        jeuDeux.setTitre(titre);
        jeuDeux.setNombreMaxJoueurs(nombreMaxJoueurs);
        jeuDeux.setPegi(pegi);
        jeuDeux.setModesDeJeu(modesDeJeu);
        jeuDeux.setType(type);


        jeuDeuxRepository.save(jeuDeux);

    }


    @Override
    public void supprimerJeuDeux(String titre) {



    }
}




