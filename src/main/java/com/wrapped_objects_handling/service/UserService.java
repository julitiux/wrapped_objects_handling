package com.wrapped_objects_handling.service;

import com.wrapped_objects_handling.domain.User;

public interface UserService {

  AddUserResult addUser(final User user);
  
}
