package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.AbsencePersonnel;

public interface AbsencePersonnelRepository extends JpaRepository<AbsencePersonnel, Long> {
}
