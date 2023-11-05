package vn.com.devmaster.project.managermaterial.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.project.managermaterial.DTO.OrderDto;
import vn.com.devmaster.project.managermaterial.domain.Order;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderMapper implements EntityMapper<Order, OrderDto>{
    @Override
    public Order toEntity(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .address(orderDto.getAddress())
                .build();
    }

    @Override
    public List<Order> toEntity(List<OrderDto> d) {
        List<Order> list = new ArrayList<>();
        d.forEach(orderDto -> {
            list.add(toEntity(orderDto));
        });
        return list;
    }

    @Override
    public OrderDto toDTO(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .ordersDate(order.getOrdersDate())
                .idorders(order.getIdorders())
                .idorders(order.getIdorders())
                .totalMoney(order.getTotalMoney())
                .notes(order.getNotes())
                .nameReciver(order.getNameReciver())
                .phone(order.getPhone())
                .build();
    }

    @Override
    public List<OrderDto> toDTO(List<Order> e) {
        List<OrderDto> list = new ArrayList<>();
        e.forEach(order -> {
            list.add(toDTO(order));
        });
        return list;
    }
}
