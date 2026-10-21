package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.AnneeScolaire;

public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, Long> {
}
