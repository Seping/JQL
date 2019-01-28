package sep.jql.interfaces.statement;

import sep.entity.struct.field.Attribute;
import sep.sql.SQLAppendable;

public interface ConditionStatement extends BinaryStatement<Attribute<?>, Object>, SQLAppendable<ConditionStatement> {
}
