package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.InformationsEtablissementScolaire;

public interface InformationsEtablissementScolaireRepository extends JpaRepository<InformationsEtablissementScolaire, Long> {
}
