package service;

import exceptions.JeuDejaExistantException;
import exceptions.JeuInexistantException;

import java.util.List;

public interface JeuDeuxService {

    String creerJeuDeux(String id, String titre, String type, int pegi, int nombreMaxJoueurs, List<String> modesDeJeu) throws JeuDejaExistantException;
    void supprimerJeuDeux(String id) throws JeuInexistantException;
    void modifierTypeJeuDeux(String id, String type) throws JeuInexistantException;

}
