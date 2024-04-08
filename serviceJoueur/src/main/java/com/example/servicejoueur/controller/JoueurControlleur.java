package com.example.servicejoueur.controller;

import com.example.servicejoueur.dto.AuthenticationRequest;
import com.example.servicejoueur.dto.RegisterDTO;
import com.example.servicejoueur.entities.Joueur;
import com.example.servicejoueur.exception.CompteDejaExistant;
import com.example.servicejoueur.exception.PseudoDejaPrisException;
import com.example.servicejoueur.repository.JoueurRepository;
import com.example.servicejoueur.securities.jwt.JwtUtil;
import com.example.servicejoueur.service.JoueurDetailsServiceImpl;
import com.example.servicejoueur.service.JoueurService;
import com.example.servicejoueur.service.JoueurServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/joueur")
public class JoueurControlleur {

    private JoueurService joueurService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JoueurDetailsServiceImpl joueurDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JoueurRepository joueurRepository;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    @Autowired
    public JoueurControlleur(JoueurServiceImpl joueurService){
        this.joueurService = joueurService;
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello2")
    public ResponseEntity hello2(){ return ResponseEntity.ok().build();}

    @PostMapping("/signUp")
    public ResponseEntity<?> register(@RequestBody RegisterDTO joueurDTO) throws PseudoDejaPrisException, CompteDejaExistant {
        if (joueurService.existByEmail(joueurDTO.email())){
            return ResponseEntity.status(NOT_ACCEPTABLE).body("Client deja créer avec ce compte");
        }
        if (joueurService.existByPseudo(joueurDTO.pseudo())){
            return ResponseEntity.status(NOT_ACCEPTABLE).body("Pseudo deja pris !");
        }
        Joueur joueur = joueurService.register(joueurDTO);
        return ResponseEntity.status(CREATED).body(joueur);
    }

    @PostMapping("/signIn")
    public void createdAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.username(),authenticationRequest.password()
            ));
        } catch (BadCredentialsException e){
            throw new BadCredentialsException("incorrect username or password");
        }

        final UserDetails userDetails = joueurDetailsService.loadUserByUsername(authenticationRequest.username());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        Joueur joueur = joueurRepository.findByPseudo(authenticationRequest.username());
        response.getWriter().write(new JSONObject().put("id", joueur.getId())
                .put("role", joueur.getRole())
                .toString()
        );

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Origin", "Authorization"
                + "X-PINGOTHER, Origin" + "X-Requested-With , Content-Type" + "Accept" + "Accept, X-Custom-Headers");

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
    }
}
