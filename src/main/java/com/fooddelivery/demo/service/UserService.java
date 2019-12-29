package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.UserDto;
import com.fooddelivery.demo.entity.User;

public interface UserService {

  UserDto save(User user);

  User findById(String userId);
}
