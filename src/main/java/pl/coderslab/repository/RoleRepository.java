package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
