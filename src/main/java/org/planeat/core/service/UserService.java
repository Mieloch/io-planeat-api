package org.planeat.core.service;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.planeat.core.db.UserRepository;
import org.planeat.core.model.User;
import org.planeat.core.model.exception.UserNotFoundException;
import org.planeat.core.model.exception.UsernameConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @NotNull
  public User register(User user) throws UsernameConflictException {
    User byUsername = userRepository.findByUsername(user.getUsername());
    if (byUsername != null || user.getId() != null) {
      throw new UsernameConflictException();
    }
    return userRepository.save(user);
  }

  @Nullable
  public User login(String username) throws UserNotFoundException {
    User byUsername = userRepository.findByUsername(username);
    if (byUsername == null) {
      throw new UserNotFoundException();
    }
    return byUsername;
  }
}
