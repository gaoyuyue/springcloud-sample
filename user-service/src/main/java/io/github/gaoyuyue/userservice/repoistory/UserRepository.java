package io.github.gaoyuyue.userservice.repoistory;

import io.github.gaoyuyue.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneWithRolesByUserName(String userName);
}
