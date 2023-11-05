package vn.com.devmaster.project.managermaterial.service;

import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.DTO.CustomerDto;
import vn.com.devmaster.project.managermaterial.DTO.OrderDto;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.domain.Order;

@Service
public interface OrderService {
    void createOrder(Order order);

}
