package vn.com.devmaster.project.managermaterial.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment_method", schema = "manager-material")
public class PaymentMethod {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", length = 250)
    private String name;

    @Lob
    @Column(name = "NOTES")
    private String notes;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "UPDATED_DATE")
    private Instant updatedDate;

    @Column(name = "ISACTIVE")
    private Byte isactive;

}