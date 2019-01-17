package sep.jql.condition;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Root;

public interface SingleAttributeSpecification<T> {

    ConditionConjunction specific(Root<T> root1, ConditionChain conditionChain);

}
