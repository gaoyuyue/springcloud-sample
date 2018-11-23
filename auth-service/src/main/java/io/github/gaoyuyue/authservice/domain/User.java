package io.github.gaoyuyue.authservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractAuditingEntity {

    private static final long serialVersionUID = -7792589782052894443L;

    @NotNull
    @Column(unique = true)
    private String userName;
    @JsonIgnore
    @NotNull
    private String passWord;
    private String name;
    private String email;

    @JsonIgnore
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<Role> roles = new HashSet<>();

    @Transient
    private Set<GrantedAuthority> authorities = new HashSet<>();

    public Set<GrantedAuthority> getAuthorities() {
        roles.forEach(role ->
                authorities.addAll(role.getAuthorities()
                        .stream().map(a ->
                                new SimpleGrantedAuthority(a.getValue()))
                        .collect(Collectors.toSet())));
        return authorities;
    }
}
