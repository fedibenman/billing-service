package com.example.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.billingservice.enitity.Bill;



@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {


}