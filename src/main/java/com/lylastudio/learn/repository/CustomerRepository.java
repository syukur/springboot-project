package com.lylastudio.learn.repository;

import com.lylastudio.learn.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
