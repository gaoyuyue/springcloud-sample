package io.github.gaoyuyue.userservice.repoistory;

import io.github.gaoyuyue.userservice.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    
}
