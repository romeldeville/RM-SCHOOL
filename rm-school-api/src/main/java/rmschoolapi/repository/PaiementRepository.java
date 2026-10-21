package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
