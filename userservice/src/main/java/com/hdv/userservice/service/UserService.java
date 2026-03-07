package com.hdv.userservice.service;

import com.hdv.userservice.entity.User;
import com.hdv.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
  private UserRepository userRepository;
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public User create(@RequestBody User user) {
    return userRepository.save(user);
  }

    public List<User> getAllUser() {
      return userRepository.findAll();
    }

    public User getUser(Long id) {
      return userRepository.findById(id).get();
    }
}
