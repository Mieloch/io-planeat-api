package org.planeat.core.db;

import org.planeat.core.model.Recipe;
import org.planeat.core.model.RecipeBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
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