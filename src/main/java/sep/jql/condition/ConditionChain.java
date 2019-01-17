package sep.jql.condition;

import sep.entity.struct.field.Attribute;

public interface ConditionChain {

    Conjunction equal(Attribute<?> leftAttribute, Object rightAttributre, ComparisonOperator operator);

    Conjunction notEqual(Attribute<?> leftAttribute, Object rightAttributre, ComparisonOperator operator);

    Conjunction greater(Attribute<?> leftAttribute, Object rightAttributre, ComparisonOperator operator);

    Conjunction greaterOrEqual(Attribute<?> leftAttribute, Object rightAttributre, ComparisonOperator operator);

    Conjunction less(Attribute<?> leftAttribute, Object rightAttributre, ComparisonOperator operator);

    Conjunction lessOrEqual(Attribute<?> leftAttribute, Object rightAttributre, ComparisonOperator operator);

    interface Conjunction {

        ConditionChain and();

        ConditionChain or();

    }

}
