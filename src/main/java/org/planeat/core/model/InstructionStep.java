package org.planeat.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "instruction_steps")
@Data
@NoArgsConstructor
public class InstructionStep {

  @Id
  @GeneratedValue
  private long id;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "step_number", nullable = false)
  private int stepNumber;

  public InstructionStep(String description, int stepNumber) {
    this.description = description;
    this.stepNumber = stepNumber;
  }
}
