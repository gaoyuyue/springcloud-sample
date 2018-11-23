package io.github.gaoyuyue.userservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Authority extends AbstractAuditingEntity {
    private static final long serialVersionUID = 275155032388041633L;

    private String name;
    private String value;
}
