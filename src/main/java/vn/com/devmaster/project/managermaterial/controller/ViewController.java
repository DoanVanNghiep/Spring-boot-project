package vn.com.devmaster.project.managermaterial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.devmaster.project.managermaterial.domain.Product;
import vn.com.devmaster.project.managermaterial.domain.ProductImage;
import vn.com.devmaster.project.managermaterial.repository.CustomerRepository;
import vn.com.devmaster.project.managermaterial.repository.ProductRepository;
import vn.com.devmaster.project.managermaterial.repository.ProductImageRepository;
import vn.com.devmaster.project.managermaterial.service.MaterialService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private MaterialService materialService;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @GetMapping("/manager-material/category")
    public String showCategory(Model model){
        model.addAttribute("category",materialService.getAllCategory());
        return "category";
    }

    @GetMapping("/manager-material/customer")
    public String showCustomer(Model model){
        model.addAttribute("customer",materialService.getAllCustomer());
        return "customer";
    }

    @GetMapping("/manager-material/product")
    public String showProduct(Model model ){
        model.addAttribute("product",materialService.getAllProduct());
        return "display/product";
    }

    @GetMapping("/manager-material/store")
    public  String showStore(Model model){
        model.addAttribute("store", productRepository.findAll());
        return "display/store";
    }

    @GetMapping("/manager-material/cart")
    public String showCart(){
        return "display/cart";
    }

    @GetMapping("/manager-material/index")
    public String showIndex(){
        return "layout/index";
    }

    @GetMapping("/register")
    public String register(){
        return "register/register";
    }
    @GetMapping("/forgot-password")
    public String forgotpassword(){
        return "password/forgot-password";
    }
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    // tìm kiếm theo id product
    @GetMapping("/manager-material/product/{id}")
   public String findByIDProduct(@PathVariable(name= "id") Integer IDproduct, Model model){
        model.addAttribute("product",materialService.getAllProduct());
        model.addAttribute("productId",productRepository.findAllById(IDproduct));
        List<ProductImage> productImage = productImageRepository.getProductImage(IDproduct);
        model.addAttribute("productImg",productImage);
        return "display/product";
    }


//    // aảnh
//    @GetMapping("/manager-material/product_image/{IDProduct}")
//    public String findImage(@PathVariable(name = "IDProduct") Integer idProduct,Model model){
////        model.addAttribute("product",materialService.getAllProduct());
////        model.addAttribute("productId",productRepository.findAllById(IDProduct));
//        List<ProductImage> productImage = productImageRepository.getProductImage(idProduct);
//        model.addAttribute("productImg",productImage);
//        return "display/product";
//    }
    @GetMapping("/test/{id}")
    public String findImage1(@PathVariable(name = "id") Integer id,Model model){
        model.addAttribute("productId",productRepository.findAllById(id));
        model.addAttribute("productImg",productImageRepository.getProductImage(id));
        return "display/test";
    }
//
//    @GetMapping("/search/{productName}/{priceName}")
//    public String search(@RequestParam("productName") String productName, @RequestParam("priceRange") String priceRange, Model model) {
//        List<Product> products = new ArrayList<>();
//        if (productName != null && !productName.isEmpty() && priceRange != null && !priceRange.isEmpty()) {
//            // Xử lý tìm kiếm sản phẩm dựa trên productName và priceRange
//            // Sử dụng productRepository để truy vấn dữ liệu
//            if (priceRange.equals("below-10tr")) {
//                products = productRepository.findAllByPriceLessThan(10000000.0);
//            } else if (priceRange.equals("10tr-15tr")) {
//                products = productRepository.findAllByPriceBetween(10000000.0, 15000000.0);
//            } else if (priceRange.equals("15tr-20tr")) {
//                products = productRepository.findAllByPriceBetween(15000000.0, 20000000.0);
//            } else if (priceRange.equals("20tr-25tr")) {
//                products = productRepository.findAllByPriceBetween(15000000.0, 20000000.0);
//            } else if (priceRange.equals("25tr-big")) {
//                products = productRepository.findAllByPriceBigThan(25000000.0);
//            }
//        }
//        model.addAttribute("products", products);
//        return "redirect:/view/manager-material/store";
//    }

//    @GetMapping("/login/{id}")
//    public String findByName(@PathVariable(name= "id")String id, Model model){
//        model.addAttribute("customer",customerRepository.findById(id));
//        return "layout/index";
//    }

}

