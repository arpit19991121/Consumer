package com.learning.mongo.Customer.repo;

import com.learning.mongo.Customer.Collections.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepo extends MongoRepository<Customer, String> {
    Optional<Customer> findByCustomerName(String customerName);
}
