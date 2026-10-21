package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
