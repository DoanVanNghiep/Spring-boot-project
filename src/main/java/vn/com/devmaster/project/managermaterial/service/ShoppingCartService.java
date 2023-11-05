package vn.com.devmaster.project.managermaterial.service;

import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.domain.Product;
import vn.com.devmaster.project.managermaterial.domain.Shoppingcart;

@Service
public interface ShoppingCartService {
    Shoppingcart addItemToCart(Product product, int qty, Customer customer);

    Shoppingcart updateItemInCart(Product product, int qty, Customer customer);

    Shoppingcart deleteItemFromCart(Product product, Customer customer);

}
