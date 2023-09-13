package com.wrapped_objects_handling.service.impl;

import com.wrapped_objects_handling.repository.UserRepository;
import com.wrapped_objects_handling.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  UserRepository userRepository;

  @Override
  public boolean login(String username, String password) {
    return userRepository.findByUsernameAndPassword(username, password).isPresent();
  }
}
