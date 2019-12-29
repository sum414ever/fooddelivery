package com.fooddelivery.demo.entity;

import com.fooddelivery.demo.enums.DeliveryAvgTime;
import java.util.List;
import lombok.Data;

@Data
public class Restaurant {

  private String id;

  private String name;

  private DeliveryAvgTime deliveryAvgTime;

  private Double deliveryPrice;

  private List<Product> menu;
}
