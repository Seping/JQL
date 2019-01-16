package sep.jql.condition;

import sep.entity.struct.field.Attribute;
import sep.sql.SQLConvertible;

public interface Condition<T> extends SQLConvertible {

    ConditionChain and();

    ConditionChain or();

}
