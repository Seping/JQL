package sep.jql.impls.request.condition.helper;

import sep.jql.impls.component.JQLLogicalOperator;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.request.condition.SpecificConditionRequest;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLSpecificRequestConditionConjunction implements ConditionConjunction {

    private QueryStatement queryStatement;
    private SpecificConditionRequest<?> conditionRequest;

    public JQLSpecificRequestConditionConjunction(QueryStatement queryStatement, SpecificConditionRequest<?> conditionRequest) {
        this.queryStatement = queryStatement;
        this.conditionRequest = conditionRequest;
    }

    @Override
    public ConditionBuilder and() {
        return new JQLSpecificRequestConditionBuilder(queryStatement, conditionRequest, JQLLogicalOperator.AND);
    }

    @Override
    public ConditionBuilder or() {
        return new JQLSpecificRequestConditionBuilder(queryStatement, conditionRequest, JQLLogicalOperator.OR);
    }
}
