package vn.com.devmaster.project.managermaterial.controller;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
//import vn.com.devmaster.project.managermaterial.domain.CustomUserDetail;
//import vn.com.devmaster.project.managermaterial.service.CustomerService;


@Controller
public class CommonController {
//    @Autowired
//    CustomerRepository customerRepository;

//    @Autowired
//    CustomerService customerService;

    @GetMapping("")
    public String showIndex(){
        return "layout/index";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login/login";
    }


//    @PostMapping("/login-check")
//    public String login(@ModelAttribute("customerDto") CustomerDto customerDto, Model model){
////        if (!customerService.checkUser(customerDto.getUsername())){
//        //if (!customerService.checkUser(username)){
//        //    return "redirect:/login";
//           // @ModelAttribute("customerDto") chỉ gồm username,password thì k ép về kiểu CustomerDto đc????
//       // }
//        if (customerService.checkPasswordUser(customerDto.getUsername(), customerDto.getPassword())){
//  //      if(!customerService.checkPasswordUser(username,password)){
//            return "redirect:/login";
//        }
//       else {
//            //List<Customer> customerList=customerService.getUser(username);
//            CustomUserDetail userDetail = new CustomUserDetail(customerDto.getUsername(), customerDto.getPassword(),"USER");
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetail,null, userDetail.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            return "redirect:/view/manager-material/store";
//           // return "display/store";
//
//        }
//    }


}