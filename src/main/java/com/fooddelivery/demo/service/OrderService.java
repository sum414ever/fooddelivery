package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.dto.OrderData;

public interface OrderService {

  OrderDto save(OrderData orderData);
}
