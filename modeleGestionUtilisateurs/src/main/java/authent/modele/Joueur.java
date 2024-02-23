package authent.modele;

import java.util.List;

public class Joueur {

    private String nom;
    private String prenom;
    private List<String> jeux;
    private String biographie;
    private String role;
    private String password;

    public Joueur(String nom, String prenom, List<String> jeux, String biographie, String role, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.jeux = jeux;
        this.biographie = biographie;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<String> getJeux() {
        return jeux;
    }

    public String getBiographie() {
        return biographie;
    }

    public String getRole() {
        return role;
    }

    public boolean checkPassword(String password){return this.password.equals(password);}
}