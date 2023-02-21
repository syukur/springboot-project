package com.lylastudio.learn.controller;


import com.lylastudio.learn.model.Customer;
import com.lylastudio.learn.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer( @RequestBody Customer customer ){
        customerRepository.save( customer );
    }

    @DeleteMapping( "{customerId}" )
    public void deleteCustomer(  @PathVariable("customerId") Integer customerId ){
        customerRepository.deleteById( customerId );
    }

    @PutMapping
    public void updateCustomer( @RequestBody Customer customer ){

       if( customerRepository.existsById( customer.getId() ) ){
            customerRepository.save( customer );
        }

    }
}
