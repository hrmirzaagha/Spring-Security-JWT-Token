package com.software.tokens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class
BaseEntity {

    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    @Min(1)
    @Column(name = "ID")
    private long id;

    @CreatedDate
    @Column(
            name = "CREATE_DATE",
            nullable = false,
            updatable = false
    )
    private Date createDate;

    @LastModifiedDate
    @Column(
            name = "UPDATE_DATE"
    )
    private Date updateDate;

    @CreatedBy
    @Column(
            name = "CREATOR"
    )
    private String creator;

}
