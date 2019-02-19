package sep.jql.interfaces.condition;

import sep.entity.struct.field.root.Root;

public interface SingleAttributeSpecification<T> {

    ConditionConjunction specific(Root<T> root1, ConditionBuilder conditionBuilder);

}
