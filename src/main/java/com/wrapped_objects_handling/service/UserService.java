package com.wrapped_objects_handling.service;

import com.wrapped_objects_handling.domain.User;

public interface UserService {

  AddUserResult addUser(final User user);

  default AddUserResult addUserSuccessful(final User saved) {
    return AddUserResult.builder()
      .success(true)
      .user(saved)
      .build();
  }

}
