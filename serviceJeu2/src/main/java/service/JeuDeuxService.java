package service;

import exceptions.JeuDejaExistantException;

import java.util.List;

public interface JeuDeuxService {

    void creerJeuDeux(String titre, String type, int pegi, List<String> rangsDisponibles, int nombreMaxJoueurs, List<String> modesDeJeu) throws JeuDejaExistantException;
    void supprimerJeuDeux(String titre);

}
