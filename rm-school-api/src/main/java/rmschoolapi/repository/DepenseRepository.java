package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Long> {
}
