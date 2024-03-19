package controleur;

import exceptions.JeuDejaExistantException;
import exceptions.JeuInexistantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.JeuDeuxServiceImpl;

import java.util.List;

@Controller
@RequestMapping()
public class JeuDeuxControleur {

    @Autowired
    private JeuDeuxServiceImpl jeuDeuxService;

    @PostMapping()
    public ResponseEntity<String> creerJeu2(@RequestParam String titre, @RequestParam String id, @RequestParam String type, @RequestParam int pegi, @RequestParam int nombreMaxJoueurs, @RequestParam List<String> modesDeJeu ) throws JeuDejaExistantException {

        String create = jeuDeuxService.creerJeuDeux(id, titre, type, pegi, nombreMaxJoueurs, modesDeJeu);
        return ResponseEntity.status(HttpStatus.CREATED).header("jeu2", create).build();


    }

    @PostMapping()
    public ResponseEntity<String> modifierTypeJeu2(@RequestParam String type, @RequestParam String id) throws JeuInexistantException {

        jeuDeuxService.modifierTypeJeuDeux(type, id);
        return ResponseEntity.ok(type);


    }
    @DeleteMapping
    public ResponseEntity<String> supprimerJeu2(@RequestParam String id) throws JeuInexistantException {

        jeuDeuxService.supprimerJeuDeux(id);
        return ResponseEntity.ok(id);


    }




}

