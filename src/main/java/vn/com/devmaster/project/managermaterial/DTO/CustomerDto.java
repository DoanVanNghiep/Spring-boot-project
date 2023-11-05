package vn.com.devmaster.project.managermaterial.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * DTO for {@link vn.com.devmaster.project.managermaterial.domain.Customer}
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Data
@Value
public class CustomerDto implements Serializable {
    int id;
    String name;
    String username;
    String password;
    String address;
    String email;
    String phone;
    String createdDate;
    Byte isactive;
}