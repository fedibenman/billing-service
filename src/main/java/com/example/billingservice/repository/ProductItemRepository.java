package com.example.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.billingservice.enitity.ProductItem;

import java.util.Collection;



public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {

    Collection<ProductItem> findByBillId(Long id);
}
