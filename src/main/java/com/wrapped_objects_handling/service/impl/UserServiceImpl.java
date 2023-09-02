package com.wrapped_objects_handling.service.impl;

import com.wrapped_objects_handling.domain.User;
import com.wrapped_objects_handling.repository.UserRepository;
import com.wrapped_objects_handling.service.AddUserResult;
import com.wrapped_objects_handling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public AddUserResult addUser(User user) {
    return null;
  }

  private AddUserResult internalAddUser(final User user){
    final var saved = userRepository.save(user);
    return addUserSuccessful(saved);
  }

}
