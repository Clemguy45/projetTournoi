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

        newJoueur.setRole(registerDTO.joueurRole());
        joueurRepository.save(newJoueur);

        return newJoueur;
    }

    @Override
    public void deleteById(Long id) {
        joueurRepository.deleteById(String.valueOf(id));
    }

    @Override
    public Joueur update(Long id, RegisterDTO registerDTO) throws PseudoDejaPrisException, CompteDejaExistant {
        Joueur joueur = joueurRepository.findById(String.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("Joueur non trouvé"));

        if (!joueur.getPseudo().equals(registerDTO.pseudo()) && joueurRepository.existsJoueurByPseudo(registerDTO.pseudo())) {
            throw new PseudoDejaPrisException();
        }
        if (!joueur.getEmail().equals(registerDTO.email()) && joueurRepository.existsJoueurByEmail(registerDTO.email())) {
            throw new CompteDejaExistant();
        }

        joueur.setEmail(registerDTO.email());
        joueur.setFirst_name(registerDTO.first_name());
        joueur.setLast_name(registerDTO.last_name());
        joueur.setPseudo(registerDTO.pseudo());
        joueur.setBiographie(registerDTO.biographie());
        joueur.setPassword(passwordEncoder.encode(registerDTO.password()));

        return joueurRepository.save(joueur);
    }

    @Override
    public Joueur findById(Long id) {
        return joueurRepository.findById(String.valueOf(id)).orElse(null);
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
