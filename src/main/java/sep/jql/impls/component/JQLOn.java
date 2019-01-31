package sep.jql.impls.component;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Root;
import sep.jql.impls.statement.JQLConditionCollectionStatement;
import sep.jql.impls.statement.JQLOnStatement;
import sep.jql.interfaces.able.Limitable;
import sep.jql.interfaces.able.Onable;
import sep.jql.interfaces.able.OrderByable;
import sep.jql.interfaces.component.Limit;
import sep.jql.interfaces.component.On;
import sep.jql.interfaces.condition.ConditionBuilder;
import sep.jql.interfaces.condition.DoubleAttributeSpecification;
import sep.jql.interfaces.condition.SingleAttributeSpecification;
import sep.jql.interfaces.statement.ConditionCollectionStatement;
import sep.jql.interfaces.statement.OnStatement;
import sep.jql.interfaces.statement.QueryStatement;

public class JQLOn<M, A, B> implements On<M, A, B> {

    private Class<A> rootClass;
    private Class<B> joinClass;

    JQLOn(QueryStatement queryStatement, Class<A> rootClass, Class<B> joinClass, DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {

        this.rootClass = rootClass;
        this.joinClass = joinClass;

        ConditionCollectionStatement conditionCollectionStatement = new JQLConditionCollectionStatement();

        Root<A> root1 = new Root<>();
        Root<B> root2 = new Root<>();
        ConditionBuilder conditionBuilder = new JQLConditionBuilder(conditionCollectionStatement);

        doubleAttributeSpecification.specific(root1, root2, conditionBuilder);

        OnStatement onStatement = new JQLOnStatement();
        onStatement.setOperand();

        queryStatement.getJoinOnCollectionStatement().getLast().setOnStatement();

    }
}
