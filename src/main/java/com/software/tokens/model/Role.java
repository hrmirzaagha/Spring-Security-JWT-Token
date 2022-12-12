package com.software.tokens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Set;

@Entity
@Table(name = "ROLES")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Role extends BaseEntity {

    @Column(
            name = "NAME",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NotBlank(message = "Role Name can not be Empty")
    private String name;

    @ManyToMany
    private Set<User> users;
}
