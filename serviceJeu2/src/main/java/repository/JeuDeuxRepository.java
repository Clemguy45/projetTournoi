package repository;

import modele.JeuDeux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuDeuxRepository extends JpaRepository<JeuDeux, String> {

    boolean alreadyExistsJeuDeux(String titre);
}
