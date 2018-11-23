package io.github.gaoyuyue.userservice.repoistory;

import io.github.gaoyuyue.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
