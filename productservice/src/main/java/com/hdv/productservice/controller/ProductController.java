package com.hdv.productservice.controller;

import com.hdv.productservice.entity.Product;
import com.hdv.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List  ;
import java.awt.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/createProduct")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }
    @GetMapping("/getProduct/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return  productService.findAllProduct();
    }
}
