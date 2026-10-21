package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
