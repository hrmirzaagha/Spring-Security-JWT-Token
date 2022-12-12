package com.software.tokens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class User extends BaseEntity{

    @Column(
            name = "FIRSTNAME",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NotBlank(message = "Username can not be Empty")
    private String firstname;


    @Column(
            name = "LASTNAME",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NotBlank(message = "Lastname can not be Empty")
    private String lastname;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Birth Date can not be Empty")
    @Column(name = "BIRTH_DATE")
    private Date birtDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERNAME_PASSWORD_ID", referencedColumnName = "ID")
    private UsernamePassword usernamePassword;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    private Set<Contact> contacts;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


}
