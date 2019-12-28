package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.OrderDto;

public interface OrderService {

  OrderDto save(String restaurantName, String phoneNumber);
}
