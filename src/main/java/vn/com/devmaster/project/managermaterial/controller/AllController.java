package vn.com.devmaster.project.managermaterial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.devmaster.project.managermaterial.DTO.CategoryDto;
import vn.com.devmaster.project.managermaterial.DTO.CustomerDto;
import vn.com.devmaster.project.managermaterial.DTO.OrderDto;
import vn.com.devmaster.project.managermaterial.DTO.ProductDto;
import vn.com.devmaster.project.managermaterial.repository.CustomerRepository;
import vn.com.devmaster.project.managermaterial.service.MaterialService;

import java.util.List;
@RestController
@RequestMapping("/manager")
public class AllController {
    @Autowired
    private MaterialService materialService;

    @Autowired
    private CustomerRepository materialRepository;
    // in ra tất cả customer

    @GetMapping("/customer")
    List<CustomerDto> getAllCustomer(){
        return materialService.getAllCustomer();
    }

    // in ra tất cả category
    @GetMapping("/category")
    List<CategoryDto> getAllCategory(){
        return materialService.getAllCategory();
    }
    // in ra tất cả orders
    @GetMapping("/order")
    List<OrderDto> getAllOrder(){
        return materialService.getAllOrder();
    }
    // in ra tất cả product
    @GetMapping("/product")
    List<ProductDto> getAllProduct(){
        return materialService.getAllProduct();
    }

}
