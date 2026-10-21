package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
}
