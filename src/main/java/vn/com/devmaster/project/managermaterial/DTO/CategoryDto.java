package vn.com.devmaster.project.managermaterial.DTO;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * DTO for {@link vn.com.devmaster.project.managermaterial.domain.Category}
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
@Value
public class CategoryDto implements Serializable {
    Integer id;
    Integer idparent;
    String name;
    String icon;
    Instant createdDate;
    String createdBy;


}