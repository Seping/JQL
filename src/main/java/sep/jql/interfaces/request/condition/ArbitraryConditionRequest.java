package sep.jql.interfaces.request.condition;

import sep.entity.struct.field.root.ArbitraryRoot;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.request.Request;

public interface ArbitraryConditionRequest extends ConditionRequest {
    ConditionConjunction appendCondition(ArbitraryRoot arbitraryRoot, ConditionConjunction conditionConjunction);
}
