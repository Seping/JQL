package sep.jql.request;

import sep.jql.ConjunctionBuilder;
import sep.jql.OnSpecification;

public abstract class OnRequest<T, R> {

    public abstract OnSpecification<T, R> request();

}
