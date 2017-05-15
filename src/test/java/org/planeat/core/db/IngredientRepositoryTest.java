package org.planeat.core.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.planeat.core.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-15.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void getAllUserIngredientsTest(){
        List<Ingredient> allUserIngredients = ingredientRepository.findAllUserIngredients(1L);
        Assert.assertNotNull(allUserIngredients);
    }
}