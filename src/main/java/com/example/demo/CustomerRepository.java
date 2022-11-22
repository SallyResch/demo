package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;


public interface CustomerRepository
        extends MongoRepository<Customer, String> {
    Optional<Customer> findCustomerByLastName(String lastName);


}
