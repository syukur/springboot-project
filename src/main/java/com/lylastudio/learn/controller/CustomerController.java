package com.lylastudio.learn.controller;


import com.lylastudio.learn.model.Customer;
import com.lylastudio.learn.repository.CustomerRepository;
import com.lylastudio.learn.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getAllCustomer(){
        return customerService.getALlCustomer();
    }

    @PostMapping
    public void addCustomer( @RequestBody Customer customer ){
        customerService.addCustomer(customer);
    }

    @DeleteMapping( "{customerId}" )
    public void deleteCustomer(  @PathVariable("customerId") Integer customerId ){
        //customerRepository.deleteById( customerId );
        customerService.deleteCustomer(customerId);
    }

    @PutMapping
    public void updateCustomer( @RequestBody Customer customer ){

        customerService.updateCustomer(customer);

//       if( customerRepository.existsById( customer.getId() ) ){
//            customerRepository.save( customer );
//        }

    }
}
