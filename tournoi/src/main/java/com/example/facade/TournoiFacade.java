package com.example.facade;

import com.example.Classe.Tournoi;

import java.util.Date;
import java.util.List;

public interface TournoiFacade {
    List<Tournoi> listeTournois();

    Tournoi obtenirTournoi(Long id);

    String creerTournoi(Tournoi tournoi);

    Long getIdJeu(Long tournoiId);

    String modifierJeu(Long tournoiId, Long idJeu);

    String getResponsable(Long tournoiId);

    String modifierResponsable(Long tournoiId, String responsable);

    String getOrganisation(Long tournoiId);

    String modifierOrganisation(Long tournoiId, String organisation);

    List<Long> getJoueursIds(Long tournoiId);

    String modifierJoueursIds(Long tournoiId, List<Long> joueurIds);

    List<Long> getEquipesIds(Long tournoiId);

    String modifierEquipesIds(Long tournoiId, List<Long> equipeIds);

    List<String> getRegles(Long tournoiId);

    String modifierRegles(Long tournoiId, List<String> regles);

    Date getDate(Long tournoiId);

    String modifierDate(Long tournoiId, Date date);

    String ajouterJoueurId(Long tournoiId, Long id);

    String ajouterEquipeId(Long tournoiId, Long id);

    String ajouterRegles(Long tournoiId, String regle);

    String supprimerJoueurId(Long tournoiId, Long id);

    String supprimerEquipeId(Long tournoiId, Long id);

    String supprimerRegleNum(Long tournoiId, int index);
}
