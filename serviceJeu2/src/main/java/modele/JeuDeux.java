package modele;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class JeuDeux {
    @Id

    private String titre;
    private long id;
    private String type;
    private int pegi;
    @ElementCollection
    private List<String> rangs;
    private int nombreMaxJoueurs;
    @ElementCollection
    private List<String> modesDeJeu;
    private String typeTournoi;

    public String getTitre() {
        return titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id++;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public List<String> getRangs() {
        return rangs;
    }

    public void setRangs(List<String> rangs) {
        this.rangs = rangs;
    }

    public int getNombreMaxJoueurs() {
        return nombreMaxJoueurs;
    }

    public void setNombreMaxJoueurs(int nombreMaxJoueurs) {
        this.nombreMaxJoueurs = nombreMaxJoueurs;
    }

    public List<String> getModesDeJeu() {
        return modesDeJeu;
    }

    public void setModesDeJeu(List<String> modesDeJeu) {
        this.modesDeJeu = modesDeJeu;
    }

    public String getTypeTournoi() {
        return typeTournoi;
    }

    public void setTypeTournoi(String typeTournoi) {
        this.typeTournoi = typeTournoi;
    }
}
