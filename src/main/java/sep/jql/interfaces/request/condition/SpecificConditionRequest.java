package sep.jql.interfaces.request.condition;

import sep.entity.struct.field.root.Root;
import sep.jql.interfaces.condition.ConditionConjunction;

public interface SpecificConditionRequest<T> extends ConditionRequest {
    ConditionConjunction appendCondition(Root<T> root, ConditionConjunction conditionConjunction);
}
