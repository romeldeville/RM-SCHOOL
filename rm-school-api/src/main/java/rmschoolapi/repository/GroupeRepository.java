package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
}
