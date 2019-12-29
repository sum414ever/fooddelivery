package com.fooddelivery.demo.repository;

import com.fooddelivery.demo.entity.Restaurant;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

  Optional<Restaurant> findById(String restaurantId);
}
