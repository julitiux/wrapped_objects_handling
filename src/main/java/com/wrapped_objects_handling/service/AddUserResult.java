package com.wrapped_objects_handling.service;

import com.wrapped_objects_handling.domain.User;
import lombok.Builder;
import lombok.Setter;

import java.util.Optional;

@Builder
@Setter
public class AddUserResult {

  @Builder.Default
  private final boolean success = false;
  private final User user;
  private final String errorMessage;
  private final Optional<Throwable> errorCause;

}
