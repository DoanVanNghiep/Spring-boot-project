package vn.com.devmaster.project.managermaterial.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link vn.com.devmaster.project.managermaterial.domain.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Value
public class ProductDto implements Serializable {
    Integer id;
    String name;
    String description;
    String notes;
    String image;
    Double price;
    Integer quatity;
    Instant createdDate;
    Instant updatedDate;
    String createdBy;
    String updatedBy;
    Byte isactive;
}