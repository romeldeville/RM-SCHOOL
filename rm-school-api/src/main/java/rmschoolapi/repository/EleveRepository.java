package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Eleve;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
}
