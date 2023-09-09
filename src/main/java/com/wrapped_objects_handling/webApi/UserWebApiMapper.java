package com.wrapped_objects_handling.webApi;

import com.wrapped_objects_handling.domain.User;
import com.wrapped_objects_handling.webApi.domain.AddUserCommand;

public class UserWebApiMapper {

  public static User of(AddUserCommand addUserCommand){
    return new User(addUserCommand.username(), addUserCommand.password());
  }
}
