package sep.jql.interfaces.request.builder;

import sep.jql.interfaces.request.Request;

public interface RequestBuilder<R extends Request> {
    Request request(R request);
}
