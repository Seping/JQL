package sep.jql.interfaces.statement;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.statement.basic.BinaryStatement;

/**
 * `app_user`.`vc_name` AS `app_user.vc_name`
 */
public interface SelectExprStatement extends BinaryStatement<Attribute<?>, String> {

}
