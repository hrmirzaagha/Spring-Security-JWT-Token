package com.software.tokens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "USERNAME_PASSWORDS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class UsernamePassword extends BaseEntity{

    @Column(
            name = "USERNAME",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String username;

    @Column(
            name = "PASSWORD",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String password;

    @OneToOne(mappedBy = "usernamePassword")
    private User user;

}
