package com.hdv.productservice.service;

import com.hdv.productservice.entity.Product;
import com.hdv.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
