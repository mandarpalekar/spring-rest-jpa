package com.example.demo.springrestjpa.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.springrestjpa.domain.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CustomerRepositoryTest
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findAll_Test(){
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);
        assertEquals(2, customers.size());
    }

    @Test
    public void findCustomerById_Test(){
        Customer customer = customerRepository.findById(1L).get();
        assertEquals("Mandar", customer.getName().getFirstName());
    }
    
}