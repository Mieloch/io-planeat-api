package org.planeat.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @ManyToMany(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
  @JoinTable(
          name="users_ingredients",
          joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id")
  )
  private List<Ingredient> ingerdientList;

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public void addIngredient(Ingredient ingredient){
    if(this.ingerdientList == null){
      this.ingerdientList = new ArrayList<>();
    }
    this.ingerdientList.add(ingredient);
  }
}
