package sep.jql.interfaces.able;

import sep.jql.interfaces.component.On;
import sep.jql.interfaces.condition.DoubleAttributeSpecification;

public interface Onable<M, A, B> {

    On<M, A, B> on(DoubleAttributeSpecification<A, B> doubleAttributeSpecification);

}
