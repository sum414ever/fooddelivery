package com.fooddelivery.demo.enums;

public enum RestaurantType {

  SUSHI(100.0), PIZZA(150.0), SHAURMA(45.0), VEGAN(200.0);

  private Double price;

  RestaurantType(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
