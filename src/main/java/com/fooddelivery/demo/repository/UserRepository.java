package com.fooddelivery.demo.repository;

import com.fooddelivery.demo.entity.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByPhoneNumber(String phoneNumber);
}
