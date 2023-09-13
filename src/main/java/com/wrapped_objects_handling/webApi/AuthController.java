package com.wrapped_objects_handling.webApi;

import com.wrapped_objects_handling.service.AuthService;
import com.wrapped_objects_handling.webApi.domain.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller("/login")
public class AuthController {

  @Autowired
  private AuthService authService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<Map<String, String>> login(@RequestBody LoginCommand loginCommand) {
    if (authService.login(loginCommand.username(), loginCommand.password()))
      return new ResponseEntity<>(Map.of("authenticated", "true"), HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

}
