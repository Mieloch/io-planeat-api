package org.planeat.web.converter;

import org.planeat.core.model.*;
import org.planeat.web.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreToWeb {

  public ProductWeb product(Product product) {
    if (product == null) {
      return null;
    }
    ProductWeb result = new ProductWeb();
    result.setCalories(product.getCalories());
    result.setCarboGrams(product.getCarboGrams());
    result.setFatGrams(product.getFatGrams());
    result.setId(product.getId());
    result.setName(product.getName());
    return result;
  }

  public List<ProductWeb> productList(List<Product> products) {
    return MappingUtils.list(products, this::product);
  }

  public IngredientWeb ingredient(Ingredient ingredient) {
    if (ingredient == null) {
      return null;
    }
    IngredientWeb result = new IngredientWeb();
    result.setId(ingredient.getId());
    result.setUnit(unit(ingredient.getUnit()));
    result.setProduct(product(ingredient.getProduct()));
    result.setQuantity(ingredient.getQuantity());
    return result;
  }

  public List<IngredientWeb> ingredientList(List<Ingredient> ingredients) {
    return MappingUtils.list(ingredients, this::ingredient);
  }

  public InstructionStepWeb instructionStep(InstructionStep instructionStep) {
    if (instructionStep == null) {
      return null;
    }
    InstructionStepWeb result = new InstructionStepWeb();
    result.setDescription(instructionStep.getDescription());
    result.setId(instructionStep.getId());
    result.setNumber(instructionStep.getStepNumber());
    return result;
  }

  public List<InstructionStepWeb> instructionStepList(List<InstructionStep> instructionSteps) {
    return MappingUtils.list(instructionSteps, this::instructionStep);
  }

  public RecipeWeb recipe(Recipe recipe) {
    if (recipe == null) {
      return null;
    }
    RecipeWeb result = new RecipeWeb();
    result.setDifficulty(difficulty(recipe.getDifficulty()));
    result.setId(recipe.getId());
    result.setIngredients(ingredientList(recipe.getIngredients()));
    result.setName(recipe.getName());
    result.setPrepareTimeMinutes(recipe.getPrepareTimeMinutes());
    result.setInstructionSteps(instructionStepList(recipe.getInstructionSteps()));
    return result;
  }

  public List<RecipeWeb> recipeList(List<Recipe> recipes) {
    return MappingUtils.list(recipes, this::recipe);
  }

  private DifficultyWeb difficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return DifficultyWeb.EASY;
      case MEDIUM:
        return DifficultyWeb.MEDIUM;
      case HARD:
        return DifficultyWeb.HARD;
      default:
        throw new IllegalArgumentException("Unable to convert Difficulty = " + difficulty.name());
    }
  }

  private UnitWeb unit(Unit unit) {
    switch (unit) {
      case GRAM:
        return UnitWeb.GRAM;
      case PINCH:
        return UnitWeb.PINCH;
      case PIECE:
        return UnitWeb.PIECE;
      case LITER:
        return UnitWeb.LITER;
      case WHOLE:
        return UnitWeb.WHOLE;
      default:
        throw new IllegalArgumentException("Unable to convert Unit = " + unit.name());
    }
  }


  public UserWeb user(User user) {
    UserWeb result = new UserWeb();
    result.setEmail(user.getEmail());
    result.setId(user.getId());
    result.setPassword(user.getPassword());
    result.setUsername(user.getUsername());
    return result;
  }


}
