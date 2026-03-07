package com.orderservice.orderservice.feign;

import com.orderservice.orderservice.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productservice")
public interface ProductClient {

    @GetMapping("/api/products/getProduct/{id}")
    ProductResponse getProductById(@PathVariable("id") long id);

}