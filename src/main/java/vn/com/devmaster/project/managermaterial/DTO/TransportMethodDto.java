package vn.com.devmaster.project.managermaterial.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link vn.com.devmaster.project.managermaterial.domain.Category}
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
@Value
public class TransportMethodDto implements Serializable {
    Integer id;
    String name;
    Instant createdDate;
    Byte isactive;
}