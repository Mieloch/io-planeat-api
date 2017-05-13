package org.planeat.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWeb {

  private Long id;
  private String username;
  private String password;
  private String email;

  public UserWeb(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
