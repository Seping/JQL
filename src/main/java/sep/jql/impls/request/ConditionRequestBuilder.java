package sep.jql.impls.request;

import sep.jql.interfaces.request.Request;
import sep.jql.interfaces.request.builder.RequestBuilder;
import sep.jql.interfaces.request.condition.ArbitraryConditionRequest;
import sep.jql.interfaces.request.condition.ConditionRequest;
import sep.jql.interfaces.request.condition.SpecificConditionRequest;

public class ConditionRequestBuilder<R extends ConditionRequest> implements RequestBuilder<R> {

    private ConditionRequestBuilder() {}

    public static <E> ConditionRequestBuilder<SpecificConditionRequest<E>> ofEntity(Class<E> entityClass) {
        return new ConditionRequestBuilder<>();
    }

    public static ConditionRequestBuilder<ArbitraryConditionRequest> ofArbitraryEntity() {
        return new ConditionRequestBuilder<>();
    }

    @Override
    public Request request(R request) {
        return request;
    }
}
