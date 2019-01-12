package com.example.demo.springrestjpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.springrestjpa.domain.Customer;
import com.example.demo.springrestjpa.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        Customer returnCustomer = customerService.createNewCustomer(customer);
        return new ResponseEntity<Customer>(returnCustomer, HttpStatus.CREATED);
    }

    @GetMapping(value = {"","/all"})
    public ResponseEntity<?> getAllCustomers(){
        List<Customer> listCustomers = new ArrayList<Customer>();
        listCustomers = customerService.findAllCustomers();
        return new ResponseEntity<List<Customer>>(listCustomers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<?> updateCustomerDetails(@RequestBody Customer customer, @PathVariable Long customerId) {
        Customer optionalCustomer = customerService.getCustomerById(customerId);
        if(optionalCustomer == null){
            return new ResponseEntity<String>("Customer with ID: " + customer.getId() + " was not found", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            customerService.saveCustomerDetails(customer);
            return new ResponseEntity<String>("Customer with ID: " + customer.getId() + " was updated", HttpStatus.OK);
        }        
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<String>("Customer with ID: " + customerId + " was deleted", HttpStatus.OK);
    }    
}