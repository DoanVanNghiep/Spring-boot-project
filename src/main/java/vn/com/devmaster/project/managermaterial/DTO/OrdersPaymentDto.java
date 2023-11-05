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
public class OrdersPaymentDto implements Serializable {
    Integer id;
    Integer total;
    String status;
}