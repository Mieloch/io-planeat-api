package org.planeat.core.db;

import org.planeat.core.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {


  List<Recipe> findAllByNameContaining(String name);

}
