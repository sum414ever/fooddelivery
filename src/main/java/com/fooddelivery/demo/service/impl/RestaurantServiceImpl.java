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
  public Restaurant getRestaurantById(String restaurantId) {
    return restaurantRepository.findById(restaurantId)
        .orElseThrow(ThereIsNoSuchElementException::new);
  }

  private RestaurantDto convertToDto(Restaurant restaurant) {

    RestaurantDto restaurantDto = new RestaurantDto();

    restaurantDto.setId(restaurant.getId());
    restaurantDto.setName(restaurant.getName());
    restaurantDto.setDeliveryAvgTime(restaurant.getDeliveryAvgTime());
    restaurantDto.setDeliveryPrice(restaurant.getDeliveryPrice());
    if (restaurant.getMenu() != null) {
      restaurantDto.setMenu(restaurant.getMenu());
    }

    return restaurantDto;
  }
}
