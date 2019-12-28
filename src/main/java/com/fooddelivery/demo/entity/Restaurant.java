package com.fooddelivery.demo.entity;

import com.fooddelivery.demo.enums.DeliveryAvgTime;
import com.fooddelivery.demo.enums.RestaurantType;
import lombok.Data;

@Data
public class Restaurant {

  private String id;

  private String name;

  private DeliveryAvgTime deliveryAvgTime;

  private RestaurantType restaurantType;

  private Double deliveryPrice;
}
