package com.wrapped_objects_handling.webApi.domain;

public record AddUserCommand(
  String username,
  String password) {
}
