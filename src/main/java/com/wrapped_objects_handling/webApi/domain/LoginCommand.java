package com.wrapped_objects_handling.webApi.domain;

public record LoginCommand(
  String username,
  String password) {
}
