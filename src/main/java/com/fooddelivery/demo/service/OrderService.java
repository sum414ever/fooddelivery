package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.dto.OrderMetaData;

public interface OrderService {

  OrderDto save(OrderMetaData orderMetaData);
}
