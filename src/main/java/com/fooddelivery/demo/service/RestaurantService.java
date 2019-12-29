package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.RestaurantDto;
import com.fooddelivery.demo.entity.Restaurant;
import java.util.List;

public interface RestaurantService {

  RestaurantDto save(Restaurant restaurant);

  List<RestaurantDto> findAll();

  Restaurant getRestaurantById(String restaurantId);
}
