package sep.jql.condition;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Root;

public interface DoubleAttributeSpecification<A, B> {

    ConditionConjunction specific(Root<A> root1, Root<B> root2, ConditionChain conditionChain);

}
