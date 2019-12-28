package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderServiceImpl orderService;

  @PostMapping("/order")
  public OrderDto makeOrder(@RequestParam("restaurantName") String restaurantName,
      @RequestParam("phone") String phoneNumber) {
    return orderService.save(restaurantName, phoneNumber);
  }
}
