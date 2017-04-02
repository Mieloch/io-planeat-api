package org.planeat.core.model;

import java.util.ArrayList;
import java.util.List;

public class InstructionStepBuilder {

  public static List<InstructionStep> pastaWithChickenAndSpinacheInstruction() {
    List<InstructionStep> instructionSteps = new ArrayList<>();
    instructionSteps.add(new InstructionStep(
            "Kurczaka kroimy na niewielkie kawałki i wrzucamy na patelnię. Smażymy przez 2-3 minuty.", 1
    ));
    instructionSteps.add(new InstructionStep(
            "Następnie dodajemy cebulę oraz czosnek (pokrojone w kostkę). Smażymy 5-6 minut.", 2
    ));
    instructionSteps.add(new InstructionStep(
            "Dodajemy śmietanę, przyprawy i dusimy 2-3 minuty.", 3
    ));
    instructionSteps.add(new InstructionStep(
            "Następnie dodajemy umyty szpinak, dusimy 2-3 minuty, dokładnie mieszamy. W międzyczasie gotujemy makaron.", 4
    ));
    instructionSteps.add(new InstructionStep(
            "Ugotowany makaron łączymy z sosem, dobrze mieszamy.", 5
    ));
    return instructionSteps;
  }

}