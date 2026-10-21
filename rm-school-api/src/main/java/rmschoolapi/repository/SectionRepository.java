package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
