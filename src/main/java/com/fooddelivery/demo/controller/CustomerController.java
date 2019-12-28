package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.CustomerDto;
import com.fooddelivery.demo.entity.Customer;
import com.fooddelivery.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping("/customer")
  public CustomerDto register(@RequestBody Customer customer) {

    return customerService.save(customer);
  }
}
