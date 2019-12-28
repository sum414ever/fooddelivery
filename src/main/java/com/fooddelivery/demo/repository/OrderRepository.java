package com.fooddelivery.demo.repository;

import com.fooddelivery.demo.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
