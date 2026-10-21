package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.InformationsPersonnel;

public interface InformationsPersonnelRepository extends JpaRepository<InformationsPersonnel, Long> {
}
