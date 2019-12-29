package com.fooddelivery.demo.dto;

import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.enums.DeliveryAvgTime;
import java.util.List;
import lombok.Data;

@Data
public class RestaurantDto {

  private String id;

  private String name;

  private DeliveryAvgTime deliveryAvgTime;

  private Double deliveryPrice;

  private List<Product> menu;
}
