package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
