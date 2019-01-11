package sep.jql.request;

import sep.jql.ConjunctionBuilder;
import sep.jql.OnSpecification;

public abstract class OnRequest {

    public abstract <T, R> void request(ConjunctionBuilder conjunctionBuilder);

}
