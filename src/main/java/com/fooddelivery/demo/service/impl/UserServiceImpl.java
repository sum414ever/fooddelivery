package com.fooddelivery.demo.service.impl;

import static com.fooddelivery.demo.utilit.UserConverter.convertToDto;

import com.fooddelivery.demo.dto.UserDto;
import com.fooddelivery.demo.entity.User;
import com.fooddelivery.demo.exception.ThereIsNoSuchElementException;
import com.fooddelivery.demo.repository.UserRepository;
import com.fooddelivery.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDto save(User user) {
    userRepository.save(user);
    return convertToDto(user);
  }

  @Override
  public User findById(String userId) {
    return userRepository.findById(userId).orElseThrow(ThereIsNoSuchElementException::new);
  }
}
