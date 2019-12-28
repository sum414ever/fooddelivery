package com.fooddelivery.demo.service.impl;

import com.fooddelivery.demo.dto.RestaurantDto;
import com.fooddelivery.demo.entity.Restaurant;
import com.fooddelivery.demo.exception.ThereIsNoSuchElementException;
import com.fooddelivery.demo.repository.RestaurantRepository;
import com.fooddelivery.demo.service.RestaurantService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;

  @Override
  public RestaurantDto save(Restaurant restaurant) {
    restaurantRepository.save(restaurant);
    return convertToDto(restaurant);
  }

  @Override
  public List<RestaurantDto> findAll() {

    List<Restaurant> restaurants = restaurantRepository.findAll();

    List<RestaurantDto> restaurantDtos = new ArrayList<>();

    for (Restaurant restaurant : restaurants) {
      restaurantDtos.add(convertToDto(restaurant));
    }
    return restaurantDtos;
  }

  @Override
  public Restaurant getRestaurantByName(String restaurantName) {

    return restaurantRepository.findByName(restaurantName)
        .orElseThrow(ThereIsNoSuchElementException::new);
  }

  private RestaurantDto convertToDto(Restaurant restaurant) {

    RestaurantDto restaurantDto = new RestaurantDto();

    restaurantDto.setName(restaurant.getName());
    restaurantDto.setTypeOfMenu(restaurant.getRestaurantType());
    restaurantDto.setDeliveryAvgTime(restaurant.getDeliveryAvgTime());
    restaurantDto.setDeliveryPrice(restaurant.getDeliveryPrice());
    restaurantDto.setPrice(restaurant.getRestaurantType().getPrice());
    restaurantDto.setTotalCost(restaurantDto.getPrice() + restaurantDto.getDeliveryPrice());

    return restaurantDto;
  }
}
