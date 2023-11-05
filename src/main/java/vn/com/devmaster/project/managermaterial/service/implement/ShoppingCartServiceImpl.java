package vn.com.devmaster.project.managermaterial.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.domain.Cartitem;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.domain.Product;
import vn.com.devmaster.project.managermaterial.domain.Shoppingcart;
import vn.com.devmaster.project.managermaterial.repository.CartItemRepository;
import vn.com.devmaster.project.managermaterial.repository.ShoppingCartRepository;
import vn.com.devmaster.project.managermaterial.service.ShoppingCartService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    CartItemRepository itemRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public Shoppingcart addItemToCart(Product product, int qty, Customer customer) {
        Shoppingcart cart = customer.getShoppingcart();
        if (cart == null){
            cart = new Shoppingcart();
        }
        Set<Cartitem> cartItems = cart.getCartitems();
        Cartitem cartitem = findCartItem(cartItems, product.getId());
        if (cartItems == null){
            cartItems = new HashSet<>();
            if (cartitem == null){
                cartitem = new Cartitem();
                cartitem.setProduct(product);
                cartitem.setTotalPrice(qty * product.getPrice());
                cartitem.setQuantity(qty);
                cartitem.setShoppingcart(cart);
                itemRepository.save(cartitem);
            }else {
                cartitem.setQuantity(cartitem.getQuantity() + qty);
                cartitem.setTotalPrice(cartitem.getQuantity() + (qty * product.getPrice()));
                itemRepository.save(cartitem);
            }
        }
        cart.setCartitems(cartItems);

        int totalItems = totalItems(cart.getCartitems());
        double totalPrice = totalPrice(cart.getCartitems());

        cart.setTotalPrice(totalPrice);
        cart.setTotalItem(totalItems);
        cart.setCustomer(customer);
        return shoppingCartRepository.save(cart);
    }

    private Cartitem findCartItem(Set<Cartitem> cartItems, Integer productId) {
        if (cartItems == null) {
            return null;
        }
        Cartitem cartItem = null;

        for (Cartitem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                cartItem = item;
            }
        }
        return cartItem;
    }

    @Override
    public Shoppingcart updateItemInCart(Product product, int qty, Customer customer) {
        return null;
    }

    @Override
    public Shoppingcart deleteItemFromCart(Product product, Customer customer) {
        return null;
    }

    private int totalItems(Set<Cartitem> cartItems){
        int totalItems = 0;
        for(Cartitem item : cartItems){
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    private double totalPrice(Set<Cartitem> cartItems){
        double totalPrice = 0.0;

        for(Cartitem item : cartItems){
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }

}
