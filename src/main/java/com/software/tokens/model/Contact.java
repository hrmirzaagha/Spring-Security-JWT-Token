package com.software.tokens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "CONTACTS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Contact extends BaseEntity {

    @Column(
            name = "ADDRESS",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NotBlank(message = "Address Code can not be Empty")
    private String address;

    @Column(
            name = "PHONE",
            columnDefinition = "TEXT",
            nullable = false
    )
    @NotBlank(message = "Phone can not be Empty")
    private String phone;

    @Column(
            name = "POSTAL_CODE",
            columnDefinition = "TEXT"
    )
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="USER_ID",
            updatable = false,
            insertable = false,
            nullable=false
    )
    private User user;
}
