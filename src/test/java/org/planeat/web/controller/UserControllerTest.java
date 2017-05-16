package org.planeat.web.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.planeat.core.db.UserRepository;
import org.planeat.core.model.User;
import org.planeat.core.model.exception.UserNotFoundException;
import org.planeat.core.service.UserService;
import org.planeat.web.converter.CoreToWeb;
import org.planeat.web.converter.WebToCore;
import org.planeat.web.model.UserWeb;


public class UserControllerTest {
  private UserController userController;

  @Before
  public void setUp() throws Exception {
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    User user = new User();
    user.setUsername("username");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    Mockito.when(userRepository.findByUsername("username")).thenReturn(user);
    Mockito.when(userRepository.findByUsername("not exist")).thenReturn(null);
    UserService userService = new UserService(userRepository);
    userController = new UserController(userService, new CoreToWeb(), new WebToCore());
  }

  @Test
  public void register() throws Exception {

  }

  @Test
  public void login() throws Exception {
    UserWeb user = new UserWeb();
    user.setUsername("username");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    UserWeb register = userController.login(user);
    Assert.assertNotNull(register);
  }

  @Test(expected = UserNotFoundException.class)
  public void login_when_not_exist() throws Exception {
    UserWeb user = new UserWeb();
    user.setUsername("not exist");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    UserWeb register = userController.login(user);
  }

}