package com.fooddelivery.demo.repository;

import com.fooddelivery.demo.entity.Customer;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  Optional<Customer> findByPhoneNumber(String phoneNumber);
}
