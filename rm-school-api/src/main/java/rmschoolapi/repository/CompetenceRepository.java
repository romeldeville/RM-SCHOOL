package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
