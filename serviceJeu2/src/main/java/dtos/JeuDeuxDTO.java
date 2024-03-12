package dtos;

import modele.JeuDeux;

import java.util.List;

public class JeuDeuxDTO {
    public static class JeuDTO {
        private String id;
        private String titre;
        private String type;
        private int pegi;
        private List<String> rangs;
        private int nombreMaxJoueurs;
        private List<String> modesDeJeu;

        // Constructeur prenant un objet Jeu pour initialiser le DTO
        public JeuDTO(JeuDeux jeuDeux) {
            this.id = String.valueOf(jeuDeux.getId());
            this.titre = jeuDeux.getTitre();
            this.type = jeuDeux.getType();
            this.pegi = jeuDeux.getPegi();
            this.rangs = jeuDeux.getRangs();
            this.nombreMaxJoueurs = jeuDeux.getNombreMaxJoueurs();
            this.modesDeJeu = jeuDeux.getModesDeJeu();
        }
    }}
