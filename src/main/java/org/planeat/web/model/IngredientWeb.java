package org.planeat.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class IngredientWeb {

  private long id;
  private int quantity;
  private UnitWeb unit;
  private ProductWeb product;

  public IngredientWeb(int quantity, UnitWeb unit, ProductWeb product) {
    this.quantity = quantity;
    this.unit = unit;
    this.product = product;
  }
}
