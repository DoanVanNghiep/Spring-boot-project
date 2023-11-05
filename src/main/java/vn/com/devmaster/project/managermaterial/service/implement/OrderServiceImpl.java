package vn.com.devmaster.project.managermaterial.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.DTO.CustomerDto;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.domain.Order;
import vn.com.devmaster.project.managermaterial.repository.OrderRepository;
import vn.com.devmaster.project.managermaterial.service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}
