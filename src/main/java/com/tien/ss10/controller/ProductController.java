package com.tien.ss10.controller;

import com.tien.ss10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/product-form")
    public String showForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "productForm";
    }

    @PostMapping("/product-save")
    public String saveProduct(@ModelAttribute("product") Product product,
                              Model model) {
        model.addAttribute("product", product);
        return "resultb2";
    }
}
