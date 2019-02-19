package sep.jql.interfaces.request.builder;

import sep.jql.interfaces.request.Request;

public interface RequestBuilder<R extends Request> {
    void request(R request);
}
