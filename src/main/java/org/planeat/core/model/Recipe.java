package org.planeat.core.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "recipes")
@Data
public class Recipe {

  @Id
  @GeneratedValue
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "prepare_time_minutes", nullable = false)
  private int prepareTimeMinutes;

  @Column(name = "difficulty", nullable = false)
  @Enumerated(EnumType.STRING)
  private Difficulty difficulty;

  @Fetch(FetchMode.SELECT)
  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinTable(
          name = "recipes_ingredients",
          joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
  )
  private List<Ingredient> ingredients;

  @Fetch(FetchMode.SELECT)
  @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = true)
  private List<InstructionStep> instructionSteps;

  public List<Product> getProducts() {
    return ingredients.stream().map(Ingredient::getProduct).collect(Collectors.toList());
  }

  public void addIngredient(Ingredient ingredient) {
    if (ingredients == null) {
      ingredients = new ArrayList<>();
    }
    ingredients.add(ingredient);
  }
}
