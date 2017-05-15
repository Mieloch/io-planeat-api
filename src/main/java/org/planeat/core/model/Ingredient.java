package org.planeat.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ingredients")
@Data
@NoArgsConstructor
public class Ingredient {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @Column(name = "unit", nullable = false)
  @Enumerated(EnumType.STRING)
  private Unit unit;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "product_id")
  private Product product;

  public Ingredient(int quantity, Unit unit, Product product) {
    this.quantity = quantity;
    this.unit = unit;
    this.product = product;
  }
}
