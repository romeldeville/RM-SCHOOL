package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {
}
