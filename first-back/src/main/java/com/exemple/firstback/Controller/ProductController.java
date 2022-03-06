package com.exemple.firstback.Controller;

import com.exemple.firstback.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
}
