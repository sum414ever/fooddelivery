package com.fooddelivery.demo.dto;

import com.fooddelivery.demo.enums.DeliveryAvgTime;
import com.fooddelivery.demo.enums.RestaurantType;
import lombok.Data;

@Data
public class RestaurantDto {

  private String name;

  private DeliveryAvgTime deliveryAvgTime;

  private RestaurantType typeOfMenu;

  private Double price;

  private Double deliveryPrice;

  private Double totalCost;
}
