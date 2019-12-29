package com.fooddelivery.demo.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderDto {

  private List<ProductDto> products;

  private Double totalCost;

  private LocalDateTime orderTime;

  private LocalDateTime deliveryTime;

  private String address;
}
