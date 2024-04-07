package com.example.facade;

import com.example.Classe.Tournoi;
import com.example.Classe.TournoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TournoiFacadeImpl implements TournoiFacade{

    private final TournoiRepository tournoiRepository;

    @Autowired
    public TournoiFacadeImpl(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    @Override
    public List<Tournoi> listeTournois() {
        return tournoiRepository.findAll(); // Récupère tous les tournois de la base de données
    }

    @Override
    public Tournoi obtenirTournoi(Long id) {
        return tournoiRepository.findById(id).orElse(null); // Récupère un tournoi par son identifiant
    }

    @Override
    public String creerTournoi(Tournoi tournoi) {
        tournoiRepository.save(tournoi); // Enregistre le tournoi dans la base de données
        return "Tournoi créé avec succès";
    }

    @Override
    public Long getIdJeu(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getIdJeu();
        }
        return null; // Si le tournoi n'existe pas dans la base de données
    }

    @Override
    public String modifierJeu(Long tournoiId, Long idJeu) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setIdJeu(idJeu); // Met à jour l'identifiant du jeu associé au tournoi
            tournoiRepository.save(tournoi);
            return "Jeu du tournoi modifié avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String getResponsable(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getResponsable();
        }
        return null;
    }
    @Override
    public String modifierResponsable(Long tournoiId, String responsable) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setResponsable(responsable);
            tournoiRepository.save(tournoi);
            return "Responsable du tournoi modifié avec succès";
        }
        return "Tournoi non trouvé";
    }
    @Override
    public String getOrganisation(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getOrganisation();
        }
        return null;
    }
    @Override
    public String modifierOrganisation(Long tournoiId, String organisation) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setOrganisation(organisation);
            tournoiRepository.save(tournoi);
            return "Organisation du tournoi modifié avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public List<Long> getJoueursIds(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getJoueursIds();
        }
        return Collections.emptyList(); // Retourne une liste vide si le tournoi n'est pas trouvé
    }

    @Override
    public String modifierJoueursIds(Long tournoiId, List<Long> joueurIds) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setJoueursIds(joueurIds);
            tournoiRepository.save(tournoi);
            return "Joueurs du tournoi modifiés avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public List<Long> getEquipesIds(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getEquipesIds();
        }
        return Collections.emptyList();
    }

    @Override
    public String modifierEquipesIds(Long tournoiId, List<Long> equipeIds) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setEquipesIds(equipeIds);
            tournoiRepository.save(tournoi);
            return "Équipes du tournoi modifiées avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public List<String> getRegles(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getRegles();
        }
        return Collections.emptyList();
    }

    @Override
    public String modifierRegles(Long tournoiId, List<String> regles) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setRegles(regles);
            tournoiRepository.save(tournoi);
            return "Regles du tournoi modifiées avec succès";
        }
        return "Tournoi non trouvé";
    }
    @Override
    public Date getDate(Long tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            return tournoi.getDate();
        }
        return null;
    }
    @Override
    public String modifierDate(Long tournoiId, Date date) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.setDate(date);
            tournoiRepository.save(tournoi);
            return "Date du tournoi modifiées avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String ajouterJoueurId(Long tournoiId, Long id) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.addJoueurId(id);
            tournoiRepository.save(tournoi);
            return "Joueur " + id + " ajouté avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String ajouterEquipeId(Long tournoiId, Long id) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.addEquipeId(id);
            tournoiRepository.save(tournoi);
            return "Equipe " + id + " ajoutée avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String ajouterRegles(Long tournoiId, String regle) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoi != null) {
            tournoi.addRegles(regle);
            tournoiRepository.save(tournoi);
            return "Regle (" + regle + ") ajoutée avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String supprimerJoueurId(Long tournoiId, Long id) {
        Tournoi tournoiFromDb = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoiFromDb != null) {
            tournoiFromDb.supprimerJoueurId(id);
            tournoiRepository.save(tournoiFromDb);
            return "Joueur " + id + " supprimé avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String supprimerEquipeId(Long tournoiId, Long id) {
        Tournoi tournoiFromDb = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoiFromDb != null) {
            tournoiFromDb.supprimerEquipeId(id);
            tournoiRepository.save(tournoiFromDb);
            return "Equipe " + id + " supprimée avec succès";
        }
        return "Tournoi non trouvé";
    }

    @Override
    public String supprimerRegleNum(Long tournoiId, int index) {
        Tournoi tournoiFromDb = tournoiRepository.findById(tournoiId).orElse(null);
        if (tournoiFromDb != null) {
            tournoiFromDb.supprimerRegleNum(index);
            tournoiRepository.save(tournoiFromDb);
            return "Règle n°" + index + " supprimée avec succès";
        }
        return "Tournoi non trouvé";
    }




    public Tournoi obtenirTournoiParJeu(String jeu) {
        // Logique pour obtenir un tournoi par le jeu
        return new Tournoi(); // Exemple de retour factice
    }

    public Tournoi obtenirTournoiParResponsable(String responsable) {
        // Logique pour obtenir un tournoi par le responsable
        return new Tournoi(); // Exemple de retour factice
    }

}
