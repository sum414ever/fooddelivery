package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.RestaurantDto;
import com.fooddelivery.demo.entity.Restaurant;
import com.fooddelivery.demo.service.impl.RestaurantServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

  private final RestaurantServiceImpl restaurantService;

  @PostMapping("/restaurant")
  public RestaurantDto addRestaurant(@RequestBody Restaurant restaurant) {
    return restaurantService.save(restaurant);
  }

  @GetMapping("/restaurant")
  private List<RestaurantDto> showAllRestaurants() {
    return restaurantService.findAll();
  }
}
