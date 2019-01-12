package com.example.demo.springrestjpa.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.springrestjpa.domain.Customer;
import com.example.demo.springrestjpa.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerService
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        List<Customer> listOfCustomers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(listOfCustomers::add);
        if(listOfCustomers.size()>0){
            return listOfCustomers;
        }
        return null;
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createNewCustomer(Customer customer){
        Customer cust = customerRepository.findById(customer.getId()).orElse(null);
        if(cust == null){
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer saveCustomerDetails(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        Customer cust = customerRepository.findById(id).orElse(null);
        if(cust != null){
            customerRepository.delete(cust);
        }          
    }
}