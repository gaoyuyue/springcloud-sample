package io.github.gaoyuyue.userservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@Data
public class Role extends AbstractAuditingEntity {

    private static final long serialVersionUID = -806779398495218902L;

    private String name;
    private String value;

    @JsonIgnore
    @ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();
}
