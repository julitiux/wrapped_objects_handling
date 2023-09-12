package com.wrapped_objects_handling.service.impl;

import com.wrapped_objects_handling.domain.User;
import com.wrapped_objects_handling.repository.UserRepository;
import com.wrapped_objects_handling.service.AddUserResult;
import com.wrapped_objects_handling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public AddUserResult addUser(User user) {
    return userRepository
      .findByUsername(user.getUsername())
      .map(this::handleExistingUser)
      .orElseGet(() -> internalAddUser(user));
  }

  @Override
  public Optional<User> findById(String id) {
    var uuid = UUID.fromString(id);
    return userRepository.findById(uuid);
  }

  private AddUserResult internalAddUser(final User user) {
    log.info("Trying to add user {}", user.getUsername());
    final var saved = userRepository.save(user);
    log.info("Added user with Id: {}", saved.getId());
    return addUserSuccessful(saved);
  }

  private AddUserResult handleExistingUser(User existingUser) {
    log.warn("The username '{}' already exits.", existingUser.getUsername());
    return duplicatedUserResult(existingUser);
  }

}
