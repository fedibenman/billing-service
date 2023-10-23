package com.example.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.billingservice.enitity.Bill;
import com.example.billingservice.enitity.Customer;
import com.example.billingservice.enitity.ProductItem;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import com.example.billingservice.service.CustomerService;
import com.example.billingservice.service.InventoryService;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
							InventoryService inventoryService, CustomerService customerService) {
		return args -> {
			Bill bill=new Bill();
			bill.setBillingDate(new Date());
			Customer customer=customerService.findCustomerById(1L);
			bill.setCustomerID(customer.getId());
			billRepository.save(bill);
			inventoryService.findAllProducts().getContent().forEach(p-> {
				productItemRepository.save(new ProductItem(null, p, p.getId(), p.getPrice(), (int)(1+Math.random()*100), bill));
			});

		};

	}}