package sep.jql.interfaces.able;

import sep.jql.interfaces.condition.SingleAttributeSpecification;

public interface Whereable<T> {

    OrderByable<T> where(SingleAttributeSpecification<T> singleAttributeSpecification);

}
