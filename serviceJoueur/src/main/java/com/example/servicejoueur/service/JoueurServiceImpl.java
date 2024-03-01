package com.example.servicejoueur.service;

import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.exception.CompteDejaExistant;
import com.example.servicejoueur.exception.PseudoDejaPrisException;
import com.example.servicejoueur.repository.JoueurRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoueurServiceImpl implements JoueurService{

    private final JoueurRepository joueurRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public JoueurServiceImpl(JoueurRepository joueurRepository, BCryptPasswordEncoder passwordEncoder){
        this.joueurRepository = joueurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Joueur register(String first_name, String last_name,
                           String email, String password,
                           String pseudo, String biographie) throws PseudoDejaPrisException, CompteDejaExistant {
        Joueur newJoueur = new Joueur();
        if(joueurRepository.existsJoueurByPseudo(pseudo)){
            throw new PseudoDejaPrisException();
        }
        if(joueurRepository.existsJoueurByEmail(email)){
            throw new CompteDejaExistant();
        }
        newJoueur.setEmail(email);
        newJoueur.setFirst_name(first_name);
        newJoueur.setLast_name(last_name);
        newJoueur.setPseudo(pseudo);
        newJoueur.setBiographie(biographie);
        newJoueur.setPassword(passwordEncoder.encode(password));

        joueurRepository.save(newJoueur);

        return newJoueur;
    }

}
