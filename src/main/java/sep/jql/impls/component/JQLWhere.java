package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.impls.statement.condition.JQLCompositeConditionExpression;
import sep.jql.impls.statement.where.JQLWhereStatement;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.SingleAttributeSpecification;
import sep.jql.interfaces.order.Order;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.query.QueryStatement;
import sep.jql.interfaces.statement.where.WhereStatement;

public class JQLWhere<M> implements OrderByable<M> {

    private QueryStatement queryStatement;

    public JQLWhere(QueryStatement queryStatement, SingleAttributeSpecification<M> singleAttributeSpecification) {

        this.queryStatement = queryStatement;

        Root<M> root = new Root<>();
        CompositeConditionExpression compositeConditionExpression = new JQLCompositeConditionExpression();

        ConditionBuilder conditionBuilder = new JQLConditionBuilder(compositeConditionExpression);

        singleAttributeSpecification.specific(root, conditionBuilder);

        WhereStatement whereStatement = new JQLWhereStatement();
        whereStatement.setConditionExpression(compositeConditionExpression);

        queryStatement.setWhereStatement(whereStatement);

    }

    @Override
    public Limitable<M> orderBy(Attribute<M> attribute, Order order) {
        return new JQLOrderBy<>(queryStatement, attribute, order);
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return new JQLLimit<>(queryStatement, offset, rowCount);
    }

}
