package sep.jql.interfaces.able;

import sep.entity.struct.field.Attribute;

public interface OrderByable<M> extends Limitable<M> {

    Limitable<M> orderBy(Attribute<M> attribute);

}
