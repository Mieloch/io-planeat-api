package org.planeat.web.controller;

import org.planeat.core.model.exception.UserNotFoundException;
import org.planeat.core.model.exception.UsernameConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

  @ResponseStatus(value = HttpStatus.CONFLICT,
          reason = "UserName in conflict with existing one")
  @ExceptionHandler(UsernameConflictException.class)
  public void usernameConflict() {

  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
  @ExceptionHandler(UserNotFoundException.class)
  public void userNotFound() {

  }
}
