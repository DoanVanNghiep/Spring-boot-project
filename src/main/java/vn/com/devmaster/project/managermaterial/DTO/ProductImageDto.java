package vn.com.devmaster.project.managermaterial.DTO;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link vn.com.devmaster.project.managermaterial.domain.Category}
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
@Value
public class ProductImageDto implements Serializable {
    Integer id;
    String name;
    String url;
}