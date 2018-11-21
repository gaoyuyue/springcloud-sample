package io.github.gaoyuyue.authservice.repoistory;

import io.github.gaoyuyue.authservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneWithRolesByUserName(String userName);
}
