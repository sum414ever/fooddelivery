package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.CustomerDto;
import com.fooddelivery.demo.entity.Customer;

public interface CustomerService {

  CustomerDto save(Customer customer);
}
