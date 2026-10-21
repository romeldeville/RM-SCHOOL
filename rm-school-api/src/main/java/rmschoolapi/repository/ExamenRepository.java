package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
