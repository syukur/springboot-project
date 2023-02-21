package com.lylastudio.learn;

import com.lylastudio.learn.model.Customer;
import com.lylastudio.learn.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Initiator {


    private  final CustomerRepository customerRepository;

    public Initiator(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void insert(){
        log.info("INSERT CUSTOMER INIT___");
        Customer customer = new Customer();
        customer.setName("ELfathan");
        customer.setAge(1);
        customer.setEmail("elfathan@gmail.com");

        Customer customer2 = new Customer();
        customer2.setName("Azka");
        customer2.setAge(7);
        customer2.setEmail("azka@gmail.com");

        customerRepository.save(customer);
        customerRepository.save(customer2);


        log.info("INSERT CUSTOMER END___");
    }

}
