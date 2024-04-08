package com.example.servicejoueur.service;

import com.example.servicejoueur.dto.RegisterDTO;
import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.enums.JoueurRole;
import com.example.servicejoueur.exception.CompteDejaExistant;
import com.example.servicejoueur.exception.PseudoDejaPrisException;
import com.example.servicejoueur.repository.JoueurRepository;
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
    public Joueur register(RegisterDTO registerDTO) throws PseudoDejaPrisException, CompteDejaExistant {
        Joueur newJoueur = new Joueur();
        if(joueurRepository.existsJoueurByPseudo(registerDTO.pseudo())){
            throw new PseudoDejaPrisException();
        }
        if(joueurRepository.existsJoueurByEmail(registerDTO.email())){
            throw new CompteDejaExistant();
        }
        newJoueur.setEmail(registerDTO.email());
        newJoueur.setFirst_name(registerDTO.first_name());
        newJoueur.setLast_name(registerDTO.last_name());
        newJoueur.setPseudo(registerDTO.pseudo());
        newJoueur.setBiographie(registerDTO.biographie());
        newJoueur.setPassword(passwordEncoder.encode(registerDTO.password()));

        newJoueur.setRole(JoueurRole.JOUEUR);
        joueurRepository.save(newJoueur);

        return newJoueur;
    }

    @Override
    public boolean existByEmail(String email) {
        return joueurRepository.existsJoueurByEmail(email);
    }

    @Override
    public boolean existByPseudo(String pseudo) {
        return joueurRepository.existsJoueurByPseudo(pseudo);
    }
}
