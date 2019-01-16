package sep.jql.able;

import sep.entity.struct.field.Attribute;

public interface OrderByable<T> extends Limitable<T>, Endable<T> {

    Limitable<T> orderBy(Attribute<T> attribute);

}
