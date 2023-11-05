package vn.com.devmaster.project.managermaterial.projection;

import java.time.Instant;

public interface IProductById {
    Integer id();
    String name();
    String username();
    String email();
    String address();
    Instant createdDate();
}
