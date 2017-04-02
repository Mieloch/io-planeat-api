package org.planeat.core.model;

public class ProductBuilder {

  public static Product chicken_breast() {
    return Product.builder().name("Pierś z kurczaka").fatGrams(1).carboGrams(0).proteinGrams(21).calories(99).build();
  }

  public static Product pasta() {
    return Product.builder().name("Makaron").fatGrams(1).carboGrams(75).proteinGrams(13).calories(371).build();
  }

  public static Product spinach() {
    return Product.builder().name("Szpinak").fatGrams(0.4).carboGrams(3.6).proteinGrams(2.9).calories(23).build();
  }

  public static Product sourCream() {
    return Product.builder().name("Śmietana").fatGrams(18).carboGrams(3.6).proteinGrams(2.5).calories(186).build();
  }

  public static Product garlic() {
    return Product.builder().name("Czosnek").fatGrams(0.5).carboGrams(33).proteinGrams(6).calories(148).build();
  }

  public static Product onion() {
    return Product.builder().name("Cebula").fatGrams(0.1).carboGrams(9).proteinGrams(1.1).calories(39).build();
  }
}