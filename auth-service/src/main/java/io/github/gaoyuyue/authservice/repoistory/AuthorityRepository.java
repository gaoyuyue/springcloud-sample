package io.github.gaoyuyue.authservice.repoistory;

import io.github.gaoyuyue.authservice.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    
}
