package org.planeat.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue
  private long id;

  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "protein", nullable = false, precision = 1)
  private double proteinGrams;
  @Column(name = "fat", nullable = false, precision = 1)
  private double fatGrams;
  @Column(name = "carbo", nullable = false, precision = 1)
  private double carboGrams;
  @Column(name = "calories", nullable = false)
  private double calories;

}
