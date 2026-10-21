package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
