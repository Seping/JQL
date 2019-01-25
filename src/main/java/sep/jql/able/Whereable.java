package sep.jql.able;

import sep.jql.condition.SingleAttributeSpecification;

public interface Whereable<T> {

    OrderByable<T> where(SingleAttributeSpecification<T> singleAttributeSpecification);

}
