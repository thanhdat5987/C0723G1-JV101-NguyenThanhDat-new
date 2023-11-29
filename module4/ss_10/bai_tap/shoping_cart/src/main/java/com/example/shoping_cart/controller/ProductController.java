package com.example.shoping_cart.controller;

import com.example.shoping_cart.model.Cart;
import com.example.shoping_cart.model.Product;
import com.example.shoping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/shop")
    public String showShop(Model model){
        model.addAttribute("products",productService.findAll());
        return ("/shop");
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product==null) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable int id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product==null) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.removeProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
}
