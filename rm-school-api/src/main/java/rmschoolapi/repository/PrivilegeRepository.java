package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
