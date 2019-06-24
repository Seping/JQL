package sep.jql.impls.request.condition.helper;

import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.attribute.ArbitraryAttribute;
import sep.entity.struct.field.attribute.Attribute;
import sep.jql.impls.component.JQLComparisionOperator;
import sep.jql.impls.component.JQLCondition;
import sep.jql.impls.statement.condition.JQLSingleConditionExpression;
import sep.jql.interfaces.condition.ComparisonOperator;
import sep.jql.interfaces.condition.Condition;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;
import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLArbitraryRequestConditionBuilder implements ConditionBuilder {

    private QueryStatement queryStatement;

    JQLArbitraryRequestConditionBuilder(QueryStatement queryStatement) {
        this.queryStatement = queryStatement;
    }

    @Override
    public ConditionConjunction equal(Attribute<?> leftAttribute, Object rightAttribute) {
        if (leftAttribute instanceof ArbitraryAttribute) {
            for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
                Entity<?> joinEntity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
                Attribute<?> joinLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(joinEntity);
                SingleConditionExpression singleConditionExpression = createCondition(joinLeftAttribute, rightAttribute, JQLComparisionOperator.EQUAL);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
            Entity<?> rootEntity = queryStatement.getFromStatement().getFromExpression().getEntity();
            Attribute<?> whereLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(rootEntity);
            SingleConditionExpression singleConditionExpression = createCondition(whereLeftAttribute, rightAttribute, JQLComparisionOperator.EQUAL);
            queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        return new JQLArbitraryRequestConditionConjunction(queryStatement);
    }

    @Override
    public ConditionConjunction notEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        if (leftAttribute instanceof ArbitraryAttribute) {
            for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
                Entity<?> joinEntity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
                Attribute<?> joinLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(joinEntity);
                SingleConditionExpression singleConditionExpression = createCondition(joinLeftAttribute, rightAttribute, JQLComparisionOperator.NOTEQUAL);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
            Entity<?> rootEntity = queryStatement.getFromStatement().getFromExpression().getEntity();
            Attribute<?> whereLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(rootEntity);
            SingleConditionExpression singleConditionExpression = createCondition(whereLeftAttribute, rightAttribute, JQLComparisionOperator.NOTEQUAL);
            queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        return new JQLArbitraryRequestConditionConjunction(queryStatement);
    }

    @Override
    public ConditionConjunction greater(Attribute<?> leftAttribute, Object rightAttribute) {
        if (leftAttribute instanceof ArbitraryAttribute) {
            for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
                Entity<?> joinEntity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
                Attribute<?> joinLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(joinEntity);
                SingleConditionExpression singleConditionExpression = createCondition(joinLeftAttribute, rightAttribute, JQLComparisionOperator.GREATER);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
            Entity<?> rootEntity = queryStatement.getFromStatement().getFromExpression().getEntity();
            Attribute<?> whereLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(rootEntity);
            SingleConditionExpression singleConditionExpression = createCondition(whereLeftAttribute, rightAttribute, JQLComparisionOperator.GREATER);
            queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        return new JQLArbitraryRequestConditionConjunction(queryStatement);
    }

    @Override
    public ConditionConjunction greaterOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        if (leftAttribute instanceof ArbitraryAttribute) {
            for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
                Entity<?> joinEntity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
                Attribute<?> joinLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(joinEntity);
                SingleConditionExpression singleConditionExpression = createCondition(joinLeftAttribute, rightAttribute, JQLComparisionOperator.GREATER_OR_EQUAL);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
            Entity<?> rootEntity = queryStatement.getFromStatement().getFromExpression().getEntity();
            Attribute<?> whereLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(rootEntity);
            SingleConditionExpression singleConditionExpression = createCondition(whereLeftAttribute, rightAttribute, JQLComparisionOperator.GREATER_OR_EQUAL);
            queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        return new JQLArbitraryRequestConditionConjunction(queryStatement);
    }

    @Override
    public ConditionConjunction less(Attribute<?> leftAttribute, Object rightAttribute) {
        if (leftAttribute instanceof ArbitraryAttribute) {
            for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
                Entity<?> joinEntity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
                Attribute<?> joinLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(joinEntity);
                SingleConditionExpression singleConditionExpression = createCondition(joinLeftAttribute, rightAttribute, JQLComparisionOperator.LESS);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
            Entity<?> rootEntity = queryStatement.getFromStatement().getFromExpression().getEntity();
            Attribute<?> whereLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(rootEntity);
            SingleConditionExpression singleConditionExpression = createCondition(whereLeftAttribute, rightAttribute, JQLComparisionOperator.LESS);
            queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        return new JQLArbitraryRequestConditionConjunction(queryStatement);
    }

    @Override
    public ConditionConjunction lessOrEqual(Attribute<?> leftAttribute, Object rightAttribute) {
        if (leftAttribute instanceof ArbitraryAttribute) {
            for (JoinOnStatement joinOnStatement : queryStatement.getJoinOnStatements().getJoinOnStatementList()) {
                Entity<?> joinEntity = joinOnStatement.getJoinStatement().getJoinExpression().getEntity();
                Attribute<?> joinLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(joinEntity);
                SingleConditionExpression singleConditionExpression = createCondition(joinLeftAttribute, rightAttribute, JQLComparisionOperator.LESS_OR_EQUAL);
                joinOnStatement.getOnStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
            }
            Entity<?> rootEntity = queryStatement.getFromStatement().getFromExpression().getEntity();
            Attribute<?> whereLeftAttribute = ((ArbitraryAttribute) leftAttribute).getAttributeByEntity(rootEntity);
            SingleConditionExpression singleConditionExpression = createCondition(whereLeftAttribute, rightAttribute, JQLComparisionOperator.LESS_OR_EQUAL);
            queryStatement.getWhereStatement().getConditionExpression().compositize().addConditionExpression(singleConditionExpression);
        }
        return new JQLArbitraryRequestConditionConjunction(queryStatement);
    }

    private SingleConditionExpression createCondition(Attribute<?> leftAttribute, Object rightAttribute, ComparisonOperator comparisonOperator) {
        Condition condition = new JQLCondition<>(leftAttribute, rightAttribute, comparisonOperator);
        SingleConditionExpression singleConditionExpression = new JQLSingleConditionExpression();
        singleConditionExpression.setCondition(condition);
        return singleConditionExpression;
    }
}
