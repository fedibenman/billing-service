package com.example.billingservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billingservice.enitity.Customer;

@FeignClient(name="CUSTOMER-SERVICE",url = "localhost:8081")
public interface CustomerService {
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable(name="id") Long id);
}
