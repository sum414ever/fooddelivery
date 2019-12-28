package com.fooddelivery.demo.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderDto {

  private String phoneNumber;

  private LocalDateTime orderTime;

  private Double totalCost;

  private LocalDateTime deliveryTime;

  private boolean isCompleted;

  private boolean isProcess;

  private String address;
}
