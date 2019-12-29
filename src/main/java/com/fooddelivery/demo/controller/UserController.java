package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.UserDto;
import com.fooddelivery.demo.entity.User;
import com.fooddelivery.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/user")
  public UserDto register(@RequestBody User user) {
    return userService.save(user);
  }
}
