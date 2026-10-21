package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.EtablissementScolaire;

public interface EtablissementScolaireRepository extends JpaRepository<EtablissementScolaire, Long> {
}
