package vn.com.devmaster.project.managermaterial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.repository.AccountRepository;
import vn.com.devmaster.project.managermaterial.service.AccountService;
import vn.com.devmaster.project.managermaterial.service.ParamService;
import vn.com.devmaster.project.managermaterial.service.SessionService;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/customer")
public class AccountController {
    @Autowired
    ParamService paramService;

    @Autowired
    AccountRepository repository;

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String viewFrom(){
        return "login/login";
    }
    @PostMapping("/check-login")
    public String login(Model model, @RequestParam(name = "username") String username, HttpSession session){
//        String username = paramService.getString("username","");
        String password = paramService.getString("password","");
        try {
            Customer customer = repository.findByUsername(username);
            if (!customer.getPassword().equals(password)){
                model.addAttribute("message","Invalid password");
            }else {
                sessionService.set("username",username);
                model.addAttribute("customer",repository.findByUsername(username));

                session.setAttribute("customer",customer);
                return "layout/index";
            }
        }catch (Exception e){
            model.addAttribute("message", "....");
        }
        return "redirect:/login";
    }

    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String viewRegister(Model model){
        model.addAttribute("Cus",new Customer());
        return "register/register";
   }

    @PostMapping("/SaveOrUpdate")
    public String saveOrUpdate(@Validated @ModelAttribute("Cus") Customer customer, BindingResult result,
                                Model model) throws IOException {
        if (result.hasErrors()){
            model.addAttribute("error","Please re-enter");
            return "register/register";
        }
        accountService.save(customer);
        model.addAttribute("Cus", new Customer());
        return "register/register";
    }
}
