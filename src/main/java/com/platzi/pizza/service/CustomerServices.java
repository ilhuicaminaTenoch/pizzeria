package com.platzi.pizza.service;

import com.platzi.pizza.persitence.entity.CustomerEntity;
import com.platzi.pizza.persitence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findByPhone(String phone) {
        return this.customerRepository.findByPhone(phone);
    }
}
