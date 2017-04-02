package org.planeat.core.db;

import org.planeat.core.model.InstructionStep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntructionStepRepository extends CrudRepository<InstructionStep, Long> {
}
