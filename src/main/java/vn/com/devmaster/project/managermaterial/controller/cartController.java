package vn.com.devmaster.project.managermaterial.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.project.managermaterial.DTO.CartDto;
import vn.com.devmaster.project.managermaterial.DTO.ProductDto;
import vn.com.devmaster.project.managermaterial.domain.*;
import vn.com.devmaster.project.managermaterial.repository.AccountRepository;
import vn.com.devmaster.project.managermaterial.repository.CartRepository;
import vn.com.devmaster.project.managermaterial.repository.ProductRepository;
import vn.com.devmaster.project.managermaterial.repository.ShoppingCartRepository;
import vn.com.devmaster.project.managermaterial.service.ShoppingCartService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/shopping-cart")
public class cartController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AccountRepository repository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;


//    @GetMapping("/add/{id}")
//    public String addCart(Model model, @PathVariable("id") Integer id, HttpSession session, HttpServletResponse response){
//        Product product = productRepository.findAllById(id);
//        if (product != null){
//            CartDto cartDto = new CartDto();
//            cartDto.setProduct(product);
//            cartDto.setQty(1);
//            cartDto.setTotalPrice(product.getPrice());
//            cartRepository.add(cartDto);
//        }
//        // tất cả product
//        session.setAttribute("all_item", cartRepository.getAll());
//
//        // đếm số product trong giỏ hàng
//        session.setAttribute("itemCount", cartRepository.getCount());
//
//        // tổng tiền
//        session.setAttribute("totalPrice", cartRepository.TotalPrice());
//        return "display/cart";
//
//    }

    @GetMapping("/addShoppingCart/{username}/{id}")
    public String addShoppingCart (@PathVariable(name = "username") String username,@PathVariable("id") Integer id,HttpSession session) {
        Customer customer = repository.findByUsername(username);
        Product product = productRepository.findAllById(id);
        if (customer == null){
            return "redirect:/customer/login";
        }
        else {
            CartDto cartDto = new CartDto();
            cartDto.setProduct(product);
            cartDto.setQty(1);
            cartDto.setTotalPrice(product.getPrice());
            cartRepository.add(cartDto);
        }
        

        return "/saveSuccess";
    }

    @GetMapping("checkout")
    public String viewCheckOut(HttpSession session){
        session.getAttribute("all_item");
        session.getAttribute("itemCount");
        session.getAttribute("totalPrice");
        return "display/checkout";
    }
}
