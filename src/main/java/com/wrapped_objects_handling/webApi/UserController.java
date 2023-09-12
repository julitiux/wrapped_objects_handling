package com.wrapped_objects_handling.webApi;

import com.wrapped_objects_handling.service.UserService;
import com.wrapped_objects_handling.webApi.domain.AddUserCommand;
import com.wrapped_objects_handling.webApi.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping(value = "/users")
  public ResponseEntity<Object> addUser(@RequestBody AddUserCommand addUserCommand) {
    final var result = userService.addUser(UserWebApiMapper.of(addUserCommand));
    if (result.isSuccess()) {
      var user = result.getUser();
      return new ResponseEntity<>(UserWebApiMapper.of(user), HttpStatus.CREATED);
    }
    return new ResponseEntity<>(result.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    return userService.findById(id)
      .map(user -> new ResponseEntity<>(UserWebApiMapper.of(user), HttpStatus.OK))
      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}
