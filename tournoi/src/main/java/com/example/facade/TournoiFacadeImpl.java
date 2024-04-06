package com.example.facade;

import com.example.Classe.Tournoi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TournoiFacadeImpl implements TournoiFacade{

    private List<Tournoi> listeTournois; // Supposons que vous stockez vos tournois ici

    public TournoiFacadeImpl() {
        this.listeTournois = new ArrayList<>();
        // Initialisation de la liste de tournois
        // Vous pouvez charger les tournois depuis une source de données, comme une base de données, ici
        // Pour cet exemple, je vais ajouter quelques tournois fictifs à la liste
        Long id=1L;
        Long idJeu=1L;
        String responsable="Benjamin";
        String organisation="BenjamIndustries";
        List<Long> joueursIds=new ArrayList<>(List.of(1L, 2L, 3L,4L));
        List<Long> equipesIds=new ArrayList<>(List.of(1L, 2L));
        List<String> règles=new ArrayList<>(List.of("Pas de cheat", "Pas de changement des paramètres"));
        Date date = new Date();

        Long id2=2L;
        Long idJeu2=2L;
        String responsable2="Clément";
        String organisation2="ClémEnterprise";
        List<Long> joueursIds2=new ArrayList<>(List.of(3L, 4L, 5L,6L));
        List<Long> equipesIds2=new ArrayList<>(List.of(2L,3L));
        List<String> règles2=new ArrayList<>(List.of("2V2", "Interdit d'utiliser les objets rouges"));
        Date date2= new Date();

        listeTournois.add(new Tournoi(id,idJeu,responsable,organisation,joueursIds,equipesIds,règles, date));
        listeTournois.add(new Tournoi(id2,idJeu2,responsable2,organisation2,joueursIds2,equipesIds2,règles2, date2));
        // Ajoutez d'autres tournois si nécessaire
    }

    public List<Tournoi> listeTournois() {
        return listeTournois; // Retournez la liste de tous les tournois
    }

    public Tournoi obtenirTournoi(Long id) {
        // Recherchez le tournoi dans la liste par son identifiant
        for (Tournoi tournoi : listeTournois) {
            if (tournoi.getId().equals(id)) {
                return tournoi; // Retournez le tournoi si trouvé
            }
        }
        return null; // Retournez null si aucun tournoi n'est trouvé avec cet identifiant
    }

    public String creerTournoi(Tournoi tournoi) {
        tournoi= new Tournoi();
        return "Tournoi créé avec succès";
    }

    public Long getJeu(Tournoi tournoi) {
        return tournoi.getIdJeu();
    }
    public String modifierJeu(Tournoi tournoi, long idJeu) {
        tournoi.setIdJeu(idJeu);
        return "Jeu du tournoi modifié avec succès";
    }

    public String getResponsable(Tournoi tournoi) {
        return tournoi.getResponsable();
    }

    public String modifierResponsable(Tournoi tournoi, String responsable) {
        tournoi.setResponsable(responsable);
        return "Responsable du tournoi modifié avec succès";
    }

    public String getOrganisation(Tournoi tournoi) {
        return tournoi.getOrganisation();
    }

    public String modifierOrganisation(Tournoi tournoi, String organisation) {
        tournoi.setOrganisation(organisation);
        return "Organisation du tournoi modifié avec succès";
    }

    public List<Long> getJoueursIds(Tournoi tournoi) {
        return tournoi.getJoueursIds();
    }
    public String modifierJoueursIds(Tournoi tournoi, List<Long>joueurIds) {
        tournoi.setJoueursIds(joueurIds);
        return "Joueurs du tournoi modifié avec succès";
    }
    public List<Long> getEquipesIds(Tournoi tournoi) {
        return tournoi.getEquipesIds();
    }
    public String modifierEquipesIds(Tournoi tournoi, List<Long>equipeIds) {
        tournoi.setEquipesIds(equipeIds);
        return "Equipes du tournoi modifié avec succès";
    }
    public List<String> getRègles(Tournoi tournoi) {
        return tournoi.getRègles();
    }
    public String modifierRègles(Tournoi tournoi, List<String>règles) {
        tournoi.setRègles(règles);
        return "Règles du tournoi modifié avec succès";
    }
    public Date getDate(Tournoi tournoi) {
        return tournoi.getDate();
    }
    public String modifierDate(Tournoi tournoi, Date date) {
        tournoi.setDate(date);
        return "Date du tournoi modifié avec succès";
    }
    public String ajouterJoueurId(Tournoi tournoi, Long id){
        tournoi.addJoueurId(id);
        return "Joueur "+id+" ajouté avec Succès";
    }
    public String ajouterEquipeId(Tournoi tournoi, Long id){
        tournoi.addEquipeId(id);
        return "Equipe "+id+" ajoutée avec Succès";
    }
    public String ajouterRègles(Tournoi tournoi, String règle){
        tournoi.addRègles(règle);
        return "Règle ("+règle+") ajoutée avec Succès";
    }

    public String supprimerJoueurId(Tournoi tournoi, Long id){
        tournoi.supprimerJoueurId(id);
        return "Joueur "+id+" supprimé avec Succès";
    }
    public String supprimerEquipeId(Tournoi tournoi, Long id){
        tournoi.supprimerEquipeId(id);
        return "Equipe "+id+" supprimée avec Succès";
    }
    public String supprimerRègleNum(Tournoi tournoi, int index){
        tournoi.supprimerRègleNum(index);
        return "Règle n°"+index+") supprimée avec Succès(à paritr de 0)";
    }




    public Tournoi obtenirTournoiParJeu(String jeu) {
        // Logique pour obtenir un tournoi par le jeu
        return new Tournoi(); // Exemple de retour factice
    }

    public Tournoi obtenirTournoiParResponsable(String responsable) {
        // Logique pour obtenir un tournoi par le responsable
        return new Tournoi(); // Exemple de retour factice
    }

    // Ajouter des méthodes similaires pour chaque attribut du tournoi
}
