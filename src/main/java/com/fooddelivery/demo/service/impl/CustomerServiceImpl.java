package com.fooddelivery.demo.service.impl;

import com.fooddelivery.demo.dto.CustomerDto;
import com.fooddelivery.demo.entity.Customer;
import com.fooddelivery.demo.exception.ThereIsNoSuchElementException;
import com.fooddelivery.demo.repository.CustomerRepository;
import com.fooddelivery.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public CustomerDto save(Customer customer) {
    customerRepository.save(customer);
    return convertToDto(customer);
  }

  public Customer getByPhoneNumber(String phoneNumber) {
    return customerRepository.findByPhoneNumber(phoneNumber)
        .orElseThrow(ThereIsNoSuchElementException::new);
  }

  private CustomerDto convertToDto(Customer customer) {

    CustomerDto customerDto = new CustomerDto();
    customerDto.setAddress(customer.getAddress());
    customerDto.setPhoneNumber(customer.getPhoneNumber());
    customerDto.setUserName(customer.getUserName());
    return customerDto;
  }
}
