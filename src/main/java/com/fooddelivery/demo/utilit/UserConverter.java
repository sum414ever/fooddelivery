package com.fooddelivery.demo.utilit;

import com.fooddelivery.demo.dto.UserDto;
import com.fooddelivery.demo.entity.User;

public class UserConverter {

  public static UserDto convertToDto(User user) {

    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setAddress(user.getAddress());
    userDto.setPhoneNumber(user.getPhoneNumber());
    userDto.setUserName(user.getUserName());
    return userDto;
  }

}
