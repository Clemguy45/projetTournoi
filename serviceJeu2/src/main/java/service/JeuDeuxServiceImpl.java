package service;

import exceptions.JeuDejaExistantException;
import exceptions.JeuInexistantException;
import modele.JeuDeux;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import repository.JeuDeuxRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JeuDeuxServiceImpl implements JeuDeuxService {

    private final JeuDeuxRepository jeuDeuxRepository;



    @Autowired
    public JeuDeuxServiceImpl(JeuDeuxRepository jeuDeuxRepository){
        this.jeuDeuxRepository = jeuDeuxRepository;

    }

    @Override
    public String creerJeuDeux(String id, String titre, String type, int pegi, int nombreMaxJoueurs, List<String> modesDeJeu) throws JeuDejaExistantException {
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

        return id;
    }


    @Override
    public void supprimerJeuDeux(String id) throws JeuInexistantException {
        if (jeuDeuxRepository.existsById(id)) {
            jeuDeuxRepository.deleteById(id); // Supprimer le jeu de la base de données
        } else {
            throw new JeuInexistantException(); // Lever une exception si le jeu n'existe pas
        }



    }
    @Override
    public void modifierTypeJeuDeux(String id, String type) throws JeuInexistantException {
        Optional<JeuDeux> optionalJeuDeux = jeuDeuxRepository.findById(id);
        if (optionalJeuDeux.isPresent()) {
            JeuDeux jeuDeux = optionalJeuDeux.get();
            jeuDeux.setType(type); // Mettre à jour le type du jeu
            jeuDeuxRepository.save(jeuDeux); // Sauvegarder les modifications
        } else {
            throw new JeuInexistantException(); // Lever une exception si le jeu n'existe pas
        }




    }
}




