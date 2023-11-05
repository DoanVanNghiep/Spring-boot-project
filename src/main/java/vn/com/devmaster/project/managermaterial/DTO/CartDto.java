package vn.com.devmaster.project.managermaterial.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.devmaster.project.managermaterial.domain.Product;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private double totalPrice = 0;
    private int qty = 1;
    private Product product ;
}
