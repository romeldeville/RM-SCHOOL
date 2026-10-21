package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Periode;

public interface PeriodeRepository extends JpaRepository<Periode, Long> {
}
