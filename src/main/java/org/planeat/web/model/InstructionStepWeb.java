package org.planeat.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstructionStepWeb {

  private long id;
  private String description;
  private int number;

  public InstructionStepWeb(String description, int number) {
    this.description = description;
    this.number = number;
  }
}
