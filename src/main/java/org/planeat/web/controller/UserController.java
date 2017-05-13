package org.planeat.web.controller;

import org.planeat.core.model.User;
import org.planeat.core.model.exception.UserNotFoundException;
import org.planeat.core.model.exception.UsernameConflictException;
import org.planeat.core.service.UserService;
import org.planeat.web.converter.CoreToWeb;
import org.planeat.web.converter.WebToCore;
import org.planeat.web.model.UserWeb;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for users CRUD operations
 */
@RestController
public class UserController {

  private final UserService userService;
  private final CoreToWeb coreToWeb;
  private final WebToCore webToCore;

  public UserController(UserService userService, CoreToWeb coreToWeb, WebToCore webToCore) {
    this.userService = userService;
    this.coreToWeb = coreToWeb;
    this.webToCore = webToCore;
  }

  @CrossOrigin
  @PostMapping("/user/register")
  public UserWeb register(@RequestBody UserWeb userWeb) throws UsernameConflictException {
    User user = webToCore.user(userWeb);
    User registered = userService.register(user);
    return coreToWeb.user(registered);
  }


  @CrossOrigin
  @PostMapping("/user/login")
  public UserWeb login(@RequestBody UserWeb user) throws UserNotFoundException {
    User login = userService.login(user.getUsername());
    return coreToWeb.user(login);
  }


}
