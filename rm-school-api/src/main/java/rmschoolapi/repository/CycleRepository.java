package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Long> {
}
