package sep.jql.impls.request.condition.helper;

import sep.jql.impls.component.JQLLogicalOperator;
import sep.jql.impls.statement.condition.JQLCompositeConditionExpression;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.query.QueryStatement;

import java.util.ArrayList;
import java.util.List;

public class JQLArbitraryRequestConditionConjunction implements ConditionConjunction {

    private QueryStatement queryStatement;
    private List<CompositeConditionExpression> joinOnCompositeConditionExpressions;
    private CompositeConditionExpression whereCompositeConditionExpression;

    public JQLArbitraryRequestConditionConjunction(QueryStatement queryStatement) {
        this.queryStatement = queryStatement;
        joinOnCompositeConditionExpressions = new ArrayList<>();
        for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
            joinOnCompositeConditionExpressions.add(joinOnStatement.getOnStatement().getConditionExpression().compositize());
        }
        if (queryStatement.getWhereStatement() == null) {
            whereCompositeConditionExpression = new JQLCompositeConditionExpression();
        } else {
            whereCompositeConditionExpression = queryStatement.getWhereStatement().getConditionExpression().compositize();
        }
    }

    @Override
    public ConditionBuilder and() {
        for (CompositeConditionExpression compositeConditionExpression : joinOnCompositeConditionExpressions) {
            compositeConditionExpression.connectConditionExpression(JQLLogicalOperator.AND);
        }
        whereCompositeConditionExpression.connectConditionExpression(JQLLogicalOperator.AND);
        return new JQLArbitraryRequestConditionBuilder(queryStatement);
    }

    @Override
    public ConditionBuilder or() {
        for (CompositeConditionExpression compositeConditionExpression : joinOnCompositeConditionExpressions) {
            compositeConditionExpression.connectConditionExpression(JQLLogicalOperator.OR);
        }
        whereCompositeConditionExpression.connectConditionExpression(JQLLogicalOperator.OR);
        return new JQLArbitraryRequestConditionBuilder(queryStatement);
    }
}
