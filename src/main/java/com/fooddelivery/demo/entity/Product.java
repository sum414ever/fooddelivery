package com.fooddelivery.demo.entity;

import lombok.Data;

@Data
public class Product {

  private String name;

  private Double price;

  private String restaurantId;
}
