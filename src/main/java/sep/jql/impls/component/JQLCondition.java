package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.condition.ComparisonOperator;
import sep.jql.interfaces.condition.Condition;
import sep.util.SQLStringUtil;

public class JQLCondition<T> implements Condition<T> {

    Attribute<T> leftAttribute;
    Object rightAttribute;
    ComparisonOperator comparisonOperator;

    public JQLCondition(Attribute<T> leftAttribute, Object rightAttribute, ComparisonOperator comparisonOperator) {
        this.leftAttribute = leftAttribute;
        this.rightAttribute = rightAttribute;
        this.comparisonOperator = comparisonOperator;
    }

    @Override
    public Attribute<T> getLeftAttribute() {
        return leftAttribute;
    }

    @Override
    public Object getRightAttribute() {
        return rightAttribute;
    }

    @Override
    public String toSQLString() {
        return leftAttribute.toSQLString() + " " + comparisonOperator.toSQLString() + " " + SQLStringUtil.toSQLValueString(rightAttribute);
    }
}
