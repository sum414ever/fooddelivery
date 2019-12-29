package com.fooddelivery.demo.repository;

import com.fooddelivery.demo.entity.Product;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

  Optional<Product> findByName(String name);
}
