package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.CompteUtilisateur;

import java.util.Optional;

public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long> {

    Optional<CompteUtilisateur> findByLogin(String login);

    boolean existsByLogin(String login);
}
