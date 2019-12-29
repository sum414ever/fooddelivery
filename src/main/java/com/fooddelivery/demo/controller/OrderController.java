package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.service.impl.OrderServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderServiceImpl orderService;

  @PostMapping("/order")
  public OrderDto makeOrder(@RequestParam("userId") String userId,
      @RequestBody List<String> productNames) {
    return orderService.save(userId, productNames);
  }
}
