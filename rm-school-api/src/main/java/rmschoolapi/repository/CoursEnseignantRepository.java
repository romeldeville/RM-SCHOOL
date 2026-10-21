package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.CoursEnseignant;

public interface CoursEnseignantRepository extends JpaRepository<CoursEnseignant, Long> {
}
