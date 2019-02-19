package sep.jql.interfaces.condition;

import sep.entity.struct.field.attribute.Attribute;

public interface ConditionBuilder {

    ConditionConjunction equal(Attribute<?> leftAttribute, Object rightAttribute);

    ConditionConjunction notEqual(Attribute<?> leftAttribute, Object rightAttribute);

    ConditionConjunction greater(Attribute<?> leftAttribute, Object rightAttribute);

    ConditionConjunction greaterOrEqual(Attribute<?> leftAttribute, Object rightAttribute);

    ConditionConjunction less(Attribute<?> leftAttribute, Object rightAttribute);

    ConditionConjunction lessOrEqual(Attribute<?> leftAttribute, Object rightAttribute);

}
