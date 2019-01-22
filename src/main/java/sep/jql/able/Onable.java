package sep.jql.able;

import sep.jql.component.On;
import sep.jql.condition.DoubleAttributeSpecification;
import sep.sql.SQLConvertible;

public interface Onable<M, A, B> extends SQLConvertible {

    On<M, A, B> on(DoubleAttributeSpecification<A, B> doubleAttributeSpecification);

}
