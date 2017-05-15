package org.planeat.core.db;

import org.planeat.core.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    @Query(value = "SELECT * FROM users as u1 join (users_ingredients as u join ingredients as i on u.ingredient_id=i.id) on u1.id=user_id where user_id=?1", nativeQuery = true)
    public List<Ingredient> findAllUserIngredients(Long userId);
}
