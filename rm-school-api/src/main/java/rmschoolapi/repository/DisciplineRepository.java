package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
