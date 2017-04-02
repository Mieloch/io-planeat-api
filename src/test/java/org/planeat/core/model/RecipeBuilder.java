package org.planeat.core.model;

public class RecipeBuilder {


  public static Recipe pastaWithChickenAndSpinache() {
    Recipe recipe = new Recipe();
    recipe.setName("Makaron z kurczakiem i szpinakiem");
    recipe.setDifficulty(Difficulty.EASY);
    recipe.setPrepareTimeMinutes(20);
    recipe.addIngredient(new Ingredient(400, Unit.GRAM, ProductBuilder.chicken_breast()));
    recipe.addIngredient(new Ingredient(200, Unit.GRAM, ProductBuilder.pasta()));
    recipe.addIngredient(new Ingredient(2, Unit.WHOLE, ProductBuilder.onion()));
    recipe.addIngredient(new Ingredient(2, Unit.PIECE, ProductBuilder.garlic()));
    recipe.addIngredient(new Ingredient(600, Unit.GRAM, ProductBuilder.spinach()));
    recipe.addIngredient(new Ingredient(300, Unit.GRAM, ProductBuilder.sourCream()));
    recipe.setInstructionSteps(InstructionStepBuilder.pastaWithChickenAndSpinacheInstruction());
    return recipe;
  }
}