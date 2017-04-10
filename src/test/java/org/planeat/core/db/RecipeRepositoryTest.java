package org.planeat.core.db;

import org.junit.runner.RunWith;
import org.planeat.core.model.Recipe;
import org.planeat.core.model.RecipeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RecipeRepositoryTest {

  @Autowired
  private RecipeRepository recipeRepository;

  @Autowired
  private IntructionStepRepository intructionStepRepository;

  @Autowired
  private ProductRepository productRepository;

  public void add_recipe() {
    Recipe recipe = RecipeBuilder.pastaWithChickenAndSpinache();
    Recipe save = recipeRepository.save(recipe);
    Recipe one = recipeRepository.findOne(save.getId());
    assertEquals(save.toString(), one.toString());
  }

}