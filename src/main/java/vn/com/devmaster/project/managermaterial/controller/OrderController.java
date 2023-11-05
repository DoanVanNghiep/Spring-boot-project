package vn.com.devmaster.project.managermaterial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.project.managermaterial.DTO.CartDto;
import vn.com.devmaster.project.managermaterial.domain.*;
import vn.com.devmaster.project.managermaterial.repository.AccountRepository;
import vn.com.devmaster.project.managermaterial.repository.CartRepository;
import vn.com.devmaster.project.managermaterial.repository.OrderDetailsRepository;
import vn.com.devmaster.project.managermaterial.repository.OrderRepository;
import vn.com.devmaster.project.managermaterial.service.OrderService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    @GetMapping("/checkout")
    public String showCheckOut(){
        return "display/checkout";
    }

    @GetMapping ("/addOrder/{username}")
    public String showOrder(Model model,HttpSession session, @PathVariable(name = "username") String username){
        Customer customer = accountRepository.findByUsername(username);
        Order order = new Order();
        String idOrder = UUID.randomUUID().toString().substring(0,10);

        order.setTotalMoney(cartRepository.getAmount());
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:MM:SS");
        order.setOrdersDate(Date.format(formatter));
        order.setIdorders(idOrder);
        order.setAddress(customer.getAddress());
        order.setNameReciver(customer.getName());
        order.setNotes("Có");
        order.setPhone(customer.getPhone());
        order.setIdcustomer(customer);
        orderRepository.save(order);



        return "/saveSuccess";
    }
}
