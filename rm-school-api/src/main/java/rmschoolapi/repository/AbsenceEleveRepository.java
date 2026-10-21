package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.AbsenceEleve;

public interface AbsenceEleveRepository extends JpaRepository<AbsenceEleve, Long> {
}
