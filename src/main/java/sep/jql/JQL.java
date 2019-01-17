package sep.jql;

import sep.entity.struct.field.Attribute;
import sep.jql.able.*;
import sep.jql.condition.SingleAttributeSpecification;

import java.util.ArrayList;

public class JQL<T> implements Joinable<T>, Whereable<T> {

    Class<T> mainClass;

    private JQL(Class<T> mainClass) {
        this.mainClass = mainClass;
    }

    public static <T> JQL<T> from(Class<T> fromClass) {
        return new JQL<>(fromClass);
    }

    @Override
    public <A, B> Onable<T, A, B> join(Class<A> rootClass, Class<B> joinClass) {
        return null;
    }

    @Override
    public OrderByable<T> where(SingleAttributeSpecification<T> singleAttributeSpecification) {
        return null;
    }

    @Override
    public Limitable<T> orderBy(Attribute<T> attribute) {
        return null;
    }

    @Override
    public Limit<T> limit(Integer offset, Integer rowCount) {
        return null;
    }

    @Override
    public JQLStatement<T> end() {
        return null;
    }

    @Override
    public String toSQLString() {
        return null;
    }
}
