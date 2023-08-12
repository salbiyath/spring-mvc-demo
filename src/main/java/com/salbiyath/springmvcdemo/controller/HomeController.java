package com.salbiyath.springmvcdemo.controller;


import com.salbiyath.springmvcdemo.entity.Product;
import com.salbiyath.springmvcdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class HomeController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Spring MVC");
        model.addAttribute("h1", "Product Management");
        model.addAttribute("products", productService.findAll());
        return "/product/index-product";
    }

    @GetMapping("/detail/{id}")
    public String findProduct(@PathVariable("id") Long id, Model model) {

        Optional<Product> product = productService.find(id);

        model.addAttribute("title", "Spring MVC");
        model.addAttribute("h1", "Product Management");
        model.addAttribute("product", product);
        return "/product/detail-product";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("title", "Spring MVC");
        model.addAttribute("h1", "Product Management");
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/save")
    public String saveProduct(Product product) {
        productService.add(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {

        Optional<Product> product = productService.find(id);

        model.addAttribute("title", "Spring MVC");
        model.addAttribute("h1", "Product Management");
        model.addAttribute("product", product);
        return "product/edit-product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.update(product);
        return "redirect:/product";
    }


}
