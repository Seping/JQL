package sep.jql.interfaces.condition;

import sep.entity.struct.field.root.Root;

public interface DoubleAttributeSpecification<A, B> {

    ConditionConjunction specific(Root<A> root1, Root<B> root2, ConditionBuilder conditionBuilder);

}
