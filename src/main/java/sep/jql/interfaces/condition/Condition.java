package sep.jql.interfaces.condition;

import sep.entity.struct.field.Attribute;
import sep.sql.SQLConvertible;

public interface Condition<T> extends SQLConvertible {

    Attribute<T> getLeftAttribute();

    Object getRightAttribute();

}
