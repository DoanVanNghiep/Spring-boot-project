package vn.com.devmaster.project.managermaterial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.repository.AccountRepository;
import vn.com.devmaster.project.managermaterial.repository.CartRepository;
import vn.com.devmaster.project.managermaterial.service.MaterialService;
import vn.com.devmaster.project.managermaterial.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/shopping-cart")
public class CheckOutController {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    AccountRepository repository;

    @Autowired
    MaterialService materialService;

    @Autowired
    SessionService sessionService;
    @GetMapping("/view/checkout")
    public String viewCheckOut(){
        return "display/checkout";
    }

    @GetMapping("check-out")
    public String checkOut(Model model, @RequestParam(name = "username") String username){
        if (checkSecurity() == true){
            model.addAttribute("customer",repository.findByUsername(username));
            return "display/checkout";
        }
        return "/login/login";
    }
    public boolean checkSecurity(){
        String username = sessionService.get("username");
        if (username != null ) return true;
        return false;
    }

}
