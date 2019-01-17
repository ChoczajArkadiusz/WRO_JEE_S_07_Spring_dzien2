package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Cart;
import pl.coderslab.CartItem;
import pl.coderslab.ProduktDao;

import java.util.List;


@Controller
public class CartController {
    private Cart cart;
    private ProduktDao produktDao;

    @Autowired
    public CartController(Cart cart, ProduktDao produktDao) {
        this.cart = cart;
        this.produktDao = produktDao;
    }

    @GetMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam Long id, @RequestParam int quantity) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == id) {
                cartItem.setQuantity(quantity + cartItem.getQuantity());
                return "addtocart";
            }
        }
        if (produktDao.getById(id) != null) {
            cart.addToCart(new CartItem(quantity, produktDao.getById(id)));
        }
        return "addtocart";
    }

    @RequestMapping("/cart")
    public String carts(Model model) {
        model.addAttribute("numOfItems", cart.numberOfItems());
        model.addAttribute("total", cart.total());
        model.addAttribute("numOfPos", cart.count());
        model.addAttribute("carts", cart.getCartItems());
        return "cart";
    }
}