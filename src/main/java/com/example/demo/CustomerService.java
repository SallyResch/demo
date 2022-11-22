package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}
