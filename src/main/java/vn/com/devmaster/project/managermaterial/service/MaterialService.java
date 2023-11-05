package vn.com.devmaster.project.managermaterial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.DTO.CategoryDto;
import vn.com.devmaster.project.managermaterial.DTO.CustomerDto;
import vn.com.devmaster.project.managermaterial.DTO.OrderDto;
import vn.com.devmaster.project.managermaterial.DTO.ProductDto;
import vn.com.devmaster.project.managermaterial.domain.Category;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.domain.Order;
import vn.com.devmaster.project.managermaterial.domain.Product;
import vn.com.devmaster.project.managermaterial.mapper.CategoryMapper;
import vn.com.devmaster.project.managermaterial.mapper.CustomerMapper;
import vn.com.devmaster.project.managermaterial.mapper.OrderMapper;
import vn.com.devmaster.project.managermaterial.mapper.ProductMapper;
import vn.com.devmaster.project.managermaterial.repository.CategoryRepository;
import vn.com.devmaster.project.managermaterial.repository.CustomerRepository;
import vn.com.devmaster.project.managermaterial.repository.OrderRepository;
import vn.com.devmaster.project.managermaterial.repository.ProductRepository;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private CustomerRepository materialRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    // get all customer
    public List<CustomerDto> getAllCustomer(){
        List<Customer> list = materialRepository.findAll();
        return customerMapper.toDTO(list);
    }

    // get all category
    public List<CategoryDto> getAllCategory(){
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toDTO(categories);
    }

    // get all order
    public List<OrderDto> getAllOrder(){
        List<Order> list = orderRepository.findAll();
        return orderMapper.toDTO(list);
    }
    // get all product
    public List<ProductDto> getAllProduct(){
        List<Product> list = productRepository.findAll();
        return productMapper.toDTO(list);
    }

}
