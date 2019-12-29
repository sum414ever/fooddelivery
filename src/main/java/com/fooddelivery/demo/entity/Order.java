package com.fooddelivery.demo.entity;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Order {

  private String id;

  private String userId;

  private LocalDateTime orderTime;

  private Double totalCost;

  private LocalDateTime deliveryTime;

  private String address;

  private List<Product> products;
}
