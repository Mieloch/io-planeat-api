package org.planeat.web.controller;

import org.planeat.core.db.RecipeRepository;
import org.planeat.core.model.Recipe;
import org.planeat.web.converter.CoreToWeb;
import org.planeat.web.model.RecipeWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

  private final RecipeRepository recipeRepository;
  private final CoreToWeb coreToWeb;

  @Autowired
  public RecipeController(RecipeRepository recipeRepository, CoreToWeb coreToWeb) {
    this.recipeRepository = recipeRepository;
    this.coreToWeb = coreToWeb;
  }

  @GetMapping("/recipes")
  public List<RecipeWeb> getAllRecipes() {
    List<Recipe> all = (List<Recipe>) recipeRepository.findAll();
    return coreToWeb.recipeList(all);
  }

  @GetMapping("/recipe")
  public List<RecipeWeb> getAllRecipes(@RequestParam String name) {
    List<Recipe> all = recipeRepository.findAllByNameContaining(name);
    return coreToWeb.recipeList(all);
  }

}
