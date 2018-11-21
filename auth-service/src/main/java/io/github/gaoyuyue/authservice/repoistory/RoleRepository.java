package io.github.gaoyuyue.authservice.repoistory;

import io.github.gaoyuyue.authservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
