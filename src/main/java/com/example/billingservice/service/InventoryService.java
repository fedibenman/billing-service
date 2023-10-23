package com.example.billingservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billingservice.enitity.Product;



@FeignClient(name="INVENTORY-SERVICE",url = "localhost:8082")
public interface InventoryService {
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable(name="id") Long id);
    @GetMapping("/products")
    public PagedModel<Product> findAllProducts();
}
