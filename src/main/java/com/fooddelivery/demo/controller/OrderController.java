package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.dto.OrderMetaData;
import com.fooddelivery.demo.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderServiceImpl orderService;

  @PostMapping("/order")
  public OrderDto makeOrder(@RequestBody OrderMetaData orderMetaData) {

    return orderService.save(orderMetaData);
  }
}
