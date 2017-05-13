package org.planeat.web.converter;

import org.planeat.core.model.User;
import org.planeat.web.model.UserWeb;
import org.springframework.stereotype.Service;

@Service
public class WebToCore {


  public User user(UserWeb user) {
    User result = new User();
    result.setEmail(user.getEmail());
    result.setId(user.getId());
    result.setPassword(user.getPassword());
    result.setUsername(user.getUsername());
    return result;
  }
}
