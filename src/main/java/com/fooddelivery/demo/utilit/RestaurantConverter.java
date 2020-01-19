package com.fooddelivery.demo.utilit;

import com.fooddelivery.demo.dto.RestaurantDto;
import com.fooddelivery.demo.entity.Restaurant;

public class RestaurantConverter {

  public static RestaurantDto convertToDto(Restaurant restaurant) {

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
