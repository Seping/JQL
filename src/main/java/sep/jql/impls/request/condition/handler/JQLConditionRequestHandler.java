package sep.jql.impls.request.condition.handler;

import sep.entity.struct.field.root.ArbitraryRoot;
import sep.entity.struct.field.root.Root;
import sep.jql.impls.request.condition.helper.JQLArbitraryRequestConditionConjunction;
import sep.jql.impls.request.condition.helper.JQLSpecificRequestConditionConjunction;
import sep.jql.interfaces.request.condition.ArbitraryConditionRequest;
import sep.jql.interfaces.request.condition.ConditionRequest;
import sep.jql.interfaces.request.condition.SpecificConditionRequest;
import sep.jql.interfaces.request.handler.RequestHandler;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLConditionRequestHandler implements RequestHandler<QueryStatement, ConditionRequest> {
    @Override
    public void handle(QueryStatement queryStatement, ConditionRequest conditionRequest) {
        if (conditionRequest instanceof ArbitraryConditionRequest) {
            handleArbitraryConditionRequest(queryStatement, (ArbitraryConditionRequest) conditionRequest);
        } else if (conditionRequest instanceof SpecificConditionRequest<?>) {
            handleSpecificConditionRequest(queryStatement, (SpecificConditionRequest<?>) conditionRequest);
        }
    }

    private void handleArbitraryConditionRequest(QueryStatement queryStatement, ArbitraryConditionRequest conditionRequest) {
        conditionRequest.appendCondition(new ArbitraryRoot(), new JQLArbitraryRequestConditionConjunction(queryStatement));
    }

    private <T> void handleSpecificConditionRequest(QueryStatement queryStatement, SpecificConditionRequest<T> conditionRequest) {
        conditionRequest.appendCondition(new Root<>(), new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest));
    }

}
