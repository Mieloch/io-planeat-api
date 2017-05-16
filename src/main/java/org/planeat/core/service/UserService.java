package org.planeat.core.service;

import org.planeat.core.db.UserRepository;
import org.planeat.core.model.User;
import org.planeat.core.model.exception.UserNotFoundException;
import org.planeat.core.model.exception.UsernameConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service responsible for User operations
 */
@Service
public class UserService {

  private final UserRepository userRepository;


  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * @param user user to register
   * @return user after registration
   * @throws UsernameConflictException - when username is in conflict with existing one
   */
  public User register(User user) throws UsernameConflictException {
    User byUsername = userRepository.findByUsername(user.getUsername());
    if (byUsername != null || user.getId() != null) {
      throw new UsernameConflictException();
    }
    return userRepository.save(user);
  }

  /**
   * @param username - username to user on which we want to log in
   * @return
   * @throws UserNotFoundException - when we try log on not existing acount
   */
  public User login(String username) throws UserNotFoundException {
    User byUsername = userRepository.findByUsername(username);
    if (byUsername == null) {
      throw new UserNotFoundException();
    }
    return byUsername;
  }
}
