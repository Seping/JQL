package sep.jql.impls.component;

import sep.entity.struct.field.Root;
import sep.jql.impls.statement.JQLConditionExpression;
import sep.jql.interfaces.component.On;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.DoubleAttributeSpecification;
import sep.jql.interfaces.statement.CompoundConditionStatement;
import sep.jql.interfaces.statement.ConditionExpression;
import sep.jql.interfaces.statement.query.QueryStatement;

public class JQLOn<M, A, B> implements On<M, A, B> {

    private Class<A> rootClass;
    private Class<B> joinClass;

    JQLOn(QueryStatement queryStatement, Class<A> rootClass, Class<B> joinClass, DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {

        this.rootClass = rootClass;
        this.joinClass = joinClass;

        ConditionExpression conditionExpression = new JQLConditionExpression();

        Root<A> root1 = new Root<>();
        Root<B> root2 = new Root<>();
        ConditionBuilder conditionBuilder = new JQLConditionBuilder(conditionExpression);

        doubleAttributeSpecification.specific(root1, root2, conditionBuilder);

        OnStatement onStatement = new JQLOnStatement();
        onStatement.setOperand();

        queryStatement.getJoinOnCollectionStatement().getLast().setOnStatement();

    }
}
