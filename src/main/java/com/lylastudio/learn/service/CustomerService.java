package com.lylastudio.learn.service;


import com.lylastudio.learn.model.Customer;
import com.lylastudio.learn.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer( Customer customer ){
        customerRepository.save( customer );
    }

    public void deleteCustomer( Integer id ){
        customerRepository.deleteById( id );
    }

    public void updateCustomer( Customer customer){
        if( customerRepository.existsById( customer.getId() ) )
            customerRepository.save(customer);
    }

    public List<Customer> getALlCustomer(){
        return customerRepository.findAll();
    }



}
