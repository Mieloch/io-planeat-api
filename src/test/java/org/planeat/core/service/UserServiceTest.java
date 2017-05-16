package org.planeat.core.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.planeat.core.db.UserRepository;
import org.planeat.core.model.User;
import org.planeat.core.model.exception.UsernameConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

  @Autowired
  private UserService userService;
  @Autowired
  private UserRepository userRepository;

  private User registered;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() {
    if (registered != null) {
      userRepository.delete(registered);
    }
  }

  @Test
  public void register() throws Exception {
    User user = new User();
    user.setUsername("username");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    registered = userService.register(user);
    User storedUser = userRepository.findByUsername("username");
    Assert.assertNotNull(storedUser);
  }

  @Test(expected = UsernameConflictException.class)
  public void register_when_username_in_conflict() throws Exception {
    User user = new User();
    user.setUsername("username");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    registered = userService.register(user);
    userService.register(user);

  }

  @Test(expected = UsernameConflictException.class)
  public void register_when_id_not_null() throws Exception {
    User user = new User();
    user.setId(1L);
    user.setUsername("username");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    userService.register(user);
  }


  @Test
  public void login() throws Exception {
    User user = new User();
    user.setId(1L);
    user.setUsername("username");
    user.setEmail("mail@mail.pl");
    user.setPassword("pass");
    registered = userService.register(user);
    User loggedUser = userService.login("username");
    Assert.assertNotNull(loggedUser);

  }

}