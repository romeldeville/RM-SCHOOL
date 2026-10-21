package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Pension;

public interface PensionRepository extends JpaRepository<Pension, Long> {
}
