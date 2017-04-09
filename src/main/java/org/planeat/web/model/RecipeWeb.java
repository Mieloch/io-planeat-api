package org.planeat.web.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RecipeWeb {

  private long id;
  private String name;
  private int prepareTimeMinutes;
  private DifficultyWeb difficulty;
  private List<IngredientWeb> ingredients;
  private List<InstructionStepWeb> instructionSteps;

}
