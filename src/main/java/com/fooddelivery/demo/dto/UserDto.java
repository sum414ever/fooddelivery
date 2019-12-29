package com.fooddelivery.demo.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserDto {

  private String id;

  private String userName;

  private String phoneNumber;

  private String address;

  private List<OrderDto> orders;
}
