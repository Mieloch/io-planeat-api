package org.planeat.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductWeb {

  private long id;

  private String name;
  private double proteinGrams;
  private double fatGrams;
  private double carboGrams;
  private double calories;

}
