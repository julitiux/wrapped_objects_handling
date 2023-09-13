package com.wrapped_objects_handling.webApi.mapper;

import com.wrapped_objects_handling.domain.User;
import com.wrapped_objects_handling.webApi.domain.AddUserCommand;
import com.wrapped_objects_handling.webApi.domain.UserDTO;

import java.util.Objects;

public class UserWebApiMapper {

  public static User of(AddUserCommand addUserCommand){
    return new User(addUserCommand.username(), addUserCommand.password());
  }

  public static UserDTO of(User user){
    return new UserDTO(Objects.requireNonNull(user.getId()).toString(), user.getUsername());
  }

}
