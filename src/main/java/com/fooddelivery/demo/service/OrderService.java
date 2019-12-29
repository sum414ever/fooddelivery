package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.OrderDto;
import java.util.List;

public interface OrderService {

  OrderDto save(String userId, List<String> productNames);
}
