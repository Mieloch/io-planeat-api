package org.planeat.web.converter;

import org.planeat.core.model.Ingredient;
import org.planeat.core.model.Product;
import org.planeat.core.model.Unit;
import org.planeat.core.model.User;
import org.planeat.web.model.IngredientWeb;
import org.planeat.web.model.ProductWeb;
import org.planeat.web.model.UnitWeb;
import org.planeat.web.model.UserWeb;
import org.springframework.stereotype.Service;

@Service
public class WebToCore {


  public User user(UserWeb user) {
    User result = new User();
    result.setEmail(user.getEmail());
    result.setId(user.getId());
    result.setPassword(user.getPassword());
    result.setUsername(user.getUsername());
    return result;
  }

  public Product product(ProductWeb productWeb){
    Product result = new Product();
    result.setId(productWeb.getId());
    result.setCalories(productWeb.getCalories());
    result.setCarboGrams(productWeb.getCarboGrams());
    result.setFatGrams(productWeb.getFatGrams());
    result.setProteinGrams(productWeb.getProteinGrams());
    result.setName(productWeb.getName());
    return result;
  }

  public Unit unit(UnitWeb unitWeb) {
    switch (unitWeb) {
      case GRAM:
        return Unit.GRAM;
      case PINCH:
        return Unit.PINCH;
      case PIECE:
        return Unit.PIECE;
      case LITER:
        return Unit.LITER;
      case WHOLE:
        return Unit.WHOLE;
      default:
        throw new IllegalArgumentException("Unable to convert Unit = " + unitWeb.name());
    }
  }

  public Ingredient ingredient(IngredientWeb ingredientWeb) {
    Ingredient result = new Ingredient();
    result.setId(ingredientWeb.getId());
    result.setProduct(product(ingredientWeb.getProduct()));
    result.setQuantity(ingredientWeb.getQuantity());
    result.setUnit(unit(ingredientWeb.getUnit()));
    return result;
  }
}
