package com.fooddelivery.demo.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Order {

  private String id;

  private String restaurantId;

  private String phoneNumber;

  private LocalDateTime orderTime;

  private Double totalCost;

  private LocalDateTime deliveryTime;

  private String address;

  private boolean isCompleted;

  private boolean isProcess;
}
