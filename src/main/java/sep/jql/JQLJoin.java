package sep.jql;

import sep.entity.resolver.EntityRepository;
import sep.jql.able.On;
import sep.jql.able.Onable;
import sep.jql.condition.DoubleAttributeSpecification;
import sep.sql.SQLConvertible;

public class JQLJoin<M, A, B> extends SQLConvertibleChain implements Onable<M, A, B> {

    Class<A> rootClass;
    Class<B> joinClass;

    public JQLJoin(Class<A> rootClass, Class<B> joinClass) {
        this.rootClass = rootClass;
        this.joinClass = joinClass;
    }

    @Override
    public On<M, A, B> on(DoubleAttributeSpecification<A, B> doubleAttributeSpecification) {
        return setNextAndReturn(new JQLOn<>(rootClass, joinClass, doubleAttributeSpecification));
    }

    @Override
    public String toSQLString() {
        return "\r\n\tLEFT JOIN " + EntityRepository.getEntity(joinClass).toSQLString();
    }


}
