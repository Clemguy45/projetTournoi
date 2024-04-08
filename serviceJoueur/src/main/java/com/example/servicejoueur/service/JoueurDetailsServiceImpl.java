package com.example.servicejoueur.service;

import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JoueurDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JoueurRepository joueurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Joueur joueur = joueurRepository.findByPseudo(username);
        if (joueur == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(joueur.getPseudo(), joueur.getPassword(), new ArrayList<>());
    }
}
