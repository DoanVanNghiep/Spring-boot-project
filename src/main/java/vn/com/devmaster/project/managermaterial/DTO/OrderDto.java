package vn.com.devmaster.project.managermaterial.DTO;

import lombok.*;
import vn.com.devmaster.project.managermaterial.domain.Customer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link vn.com.devmaster.project.managermaterial.domain.Order}
 */
@Builder
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class OrderDto implements Serializable {
    public class OrderDetailsDTO{
        private int idProduct;
        private String price;
        private Long qty;
    }
    public class PaymentDTO{
        private int idPayment;
        private Double total;
    }
    public class TransportDTO{
        private int idTransport;
        private double total;
    }
    Integer id;
    String ordersDate;
    String idorders;
    Customer idcustomer;
    Double totalMoney;
    String notes;
    String nameReciver;
    String address;
    String phone;

    private List<OrderDetailsDTO> orderDetailsDTO;
    private PaymentDTO paymentDTO;
    private TransportDTO transportDTO;
}