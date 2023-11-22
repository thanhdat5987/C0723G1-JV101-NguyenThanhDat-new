package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping()
    public String showIndex(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product,RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Adding new product successfully");
        return "redirect:/products";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes){
        productService.remove(id);
        attributes.addFlashAttribute("success", "Deleted product successfully!");
        return "redirect:/product";
    }

//    @PostMapping("/delete")
//    public String delete(Product product, RedirectAttributes redirect) {
//        productService.remove(product.getId());
//        redirect.addFlashAttribute("success", "Removing product successfully!");
//        return "redirect:/products";
//    }
    @GetMapping("/{id}/details")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/details";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/products";
    }
    @GetMapping("/findByName")
    public String findByName(String findingName, Model model ){
        model.addAttribute("productList", productService.findByName(findingName));
        return "/index";
    }
}
