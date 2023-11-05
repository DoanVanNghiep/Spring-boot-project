package vn.com.devmaster.project.managermaterial.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.project.managermaterial.DTO.CustomerDto;
import vn.com.devmaster.project.managermaterial.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements EntityMapper<Customer, CustomerDto>{
    @Override
    public Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .username(customerDto.getUsername())
                .password(customerDto.getPassword())
                .build();
    }

    @Override
    public List<Customer> toEntity(List<CustomerDto> d) {
        List<Customer> list = new ArrayList<>();
        d.forEach(customerDto -> {
            list.add(toEntity(customerDto));
        });
        return list;
    }

    @Override
    public CustomerDto toDTO(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .name(customer.getName())
                .build();
    }

    @Override
    public List<CustomerDto> toDTO(List<Customer> e) {
        List<CustomerDto> list = new ArrayList<>();
        e.forEach(customer -> {
            list.add(toDTO(customer));
        });
        return list;
    }
}
