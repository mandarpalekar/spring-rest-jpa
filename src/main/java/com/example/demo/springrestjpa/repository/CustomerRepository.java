package com.example.demo.springrestjpa.repository;

import com.example.demo.springrestjpa.domain.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}