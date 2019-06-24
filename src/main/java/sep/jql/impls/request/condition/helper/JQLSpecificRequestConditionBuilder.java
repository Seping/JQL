package sep.jql.impls.request.condition.helper;

import sep.entity.struct.field.attribute.Attribute;
import sep.jql.impls.component.JQLComparisionOperator;
import sep.jql.impls.component.JQLCondition;
import sep.jql.impls.component.JQLLogicalOperator;
import sep.jql.impls.statement.condition.JQLSingleConditionExpression;
import sep.jql.impls.statement.where.JQLWhereStatement;
import sep.jql.interfaces.condition.*;
import sep.jql.interfaces.request.condition.SpecificConditionRequest;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;
import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.query.QueryStatement;
import sep.jql.interfaces.statement.where.WhereStatement;

public class JQLSpecificRequestConditionBuilder implements ConditionBuilder {

    private QueryStatement queryStatement;
    private SpecificConditionRequest<?> conditionRequest;
    private LogicalOperator logicalOperator;

    public JQLSpecificRequestConditionBuilder(QueryStatement queryStatement, SpecificConditionRequest<?> conditionRequest, LogicalOperator logicalOperator) {
        this.queryStatement = queryStatement;
        this.conditionRequest = conditionRequest;
        this.logicalOperator = logicalOperator;
    }

    @Override
    public ConditionConjunction equal(Attribute<?> leftAttribute, Object rightAttribute) {
        SingleConditionExpression singleConditionExpression = createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.EQUAL);
        appendToJoinOnStatement(leftAttribute, singleConditionExpression);
        appendToWhereStatement(leftAttribute, singleConditionExpression);
        return new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest);
    }

    @Override
    public ConditionConjunction notEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        SingleConditionExpression singleConditionExpression = createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.NOTEQUAL);
        appendToJoinOnStatement(leftAttribute, singleConditionExpression);
        appendToWhereStatement(leftAttribute, singleConditionExpression);
        return new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest);
    }

    @Override
    public ConditionConjunction greater(Attribute<?> leftAttribute, Object rightAttribute) {
        SingleConditionExpression singleConditionExpression = createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.GREATER);
        appendToJoinOnStatement(leftAttribute, singleConditionExpression);
        appendToWhereStatement(leftAttribute, singleConditionExpression);
        return new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest);
    }

    @Override
    public ConditionConjunction greaterOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        SingleConditionExpression singleConditionExpression = createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.GREATER_OR_EQUAL);
        appendToJoinOnStatement(leftAttribute, singleConditionExpression);
        appendToWhereStatement(leftAttribute, singleConditionExpression);
        return new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest);
    }

    @Override
    public ConditionConjunction less(Attribute<?> leftAttribute, Object rightAttribute) {
        SingleConditionExpression singleConditionExpression = createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.LESS);
        appendToJoinOnStatement(leftAttribute, singleConditionExpression);
        appendToWhereStatement(leftAttribute, singleConditionExpression);
        return new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest);
    }

    @Override
    public ConditionConjunction lessOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        SingleConditionExpression singleConditionExpression = createCondition(leftAttribute, rightAttribute, JQLComparisionOperator.LESS_OR_EQUAL);
        appendToJoinOnStatement(leftAttribute, singleConditionExpression);
        appendToWhereStatement(leftAttribute, singleConditionExpression);
        return new JQLSpecificRequestConditionConjunction(queryStatement, conditionRequest);
    }

    private SingleConditionExpression createCondition(Attribute<?> leftAttribute, Object rightAttribute, ComparisonOperator comparisonOperator) {
        Condition condition = new JQLCondition<>(leftAttribute, rightAttribute, comparisonOperator);
        SingleConditionExpression singleConditionExpression = new JQLSingleConditionExpression();
        singleConditionExpression.setCondition(condition);
        return singleConditionExpression;
    }

    private void appendToJoinOnStatement(Attribute leftAttribute, SingleConditionExpression singleConditionExpression) {
        for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
            if (joinOnStatement.getJoinStatement().getJoinExpression().getEntity().getAttribute(leftAttribute) != null) {
                joinOnStatement.getOnStatement().getConditionExpression().compositize().connectConditionExpression(logicalOperator);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
        }
    }

    private void appendToWhereStatement(Attribute leftAttribute, SingleConditionExpression singleConditionExpression) {
        if (queryStatement.getFromStatement().getFromExpression().getEntity().getAttribute(leftAttribute) != null) {
            if (queryStatement.getWhereStatement() == null) {
                WhereStatement whereStatement = new JQLWhereStatement();
                whereStatement.setConditionExpression(singleConditionExpression);
                queryStatement.setWhereStatement(new JQLWhereStatement());
            } else {
                WhereStatement whereStatement = queryStatement.getWhereStatement();
                whereStatement.getConditionExpression().compositize().connectConditionExpression(logicalOperator);
                whereStatement.getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
        }
    }
}
