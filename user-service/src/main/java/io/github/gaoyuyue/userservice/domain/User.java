package io.github.gaoyuyue.userservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractAuditingEntity {

    private static final long serialVersionUID = 416775081895530586L;

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
}
