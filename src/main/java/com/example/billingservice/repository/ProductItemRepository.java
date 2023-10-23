package com.example.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.billingservice.enitity.ProductItem;

import java.util.Collection;


@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {

    Collection<ProductItem> findByBillId(Long id);
}
