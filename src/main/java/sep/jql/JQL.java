package sep.jql;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Field;
import sep.jql.able.*;
import sep.jql.component.Limit;
import sep.jql.condition.SingleAttributeSpecification;
import sep.jql.statement.SelectStatement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JQL<M> extends SQLConvertibleChain implements SingleJoinable<M>, Whereable<M> {

    Class<M> mainClass;

    private JQL(Class<M> mainClass) {
        this.mainClass = mainClass;
    }

    public static <M> JQL<M> from(Class<M> fromClass) {
        return new JQL<>(fromClass);
    }

    @Override
    public <B> Onable<M, M, B> join(Class<B> joinClass) {
        return setNextAndReturn(new JQLJoin<>(mainClass, joinClass));
    }

    @Override
    public OrderByable<M> where(SingleAttributeSpecification<M> singleAttributeSpecification) {
        return setNextAndReturn(new JQLWhere<>(singleAttributeSpecification));
    }

    @Override
    public Limitable<M> orderBy(Attribute<M> attribute) {
        return setNextAndReturn(new JQLOrderBy<>(attribute));
    }

    @Override
    public Limit<M> limit(Integer offset, Integer rowCount) {
        return setNextAndReturn(new JQLLimit<>(offset, rowCount));
    }

    @Override
    public String toSQLString() {
        StringBuffer stringBuffer = new StringBuffer("SELECT ");

        List<Entity<?>> entities = getEntities();
        for (Entity<?> entity : entities) {
            for (Field<?, ?> field : entity.getFields()) {
                stringBuffer.append(entity.toSQLString());
                stringBuffer.append(".");
                stringBuffer.append(field.toSQLString());
                stringBuffer.append(" AS `");
                stringBuffer.append(entity.getTableName());
                stringBuffer.append(".");
                stringBuffer.append(field.getColumnName());
                stringBuffer.append("`, ");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(", "));

        stringBuffer.append("\r\n");
        stringBuffer.append("FROM ");
        stringBuffer.append(EntityRepository.getEntity(mainClass).toSQLString());

        return stringBuffer.toString();
    }

    private List<Entity<?>> getEntities() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(mainClass);

        for (SQLConvertibleChain chain = this;
        chain instanceof JQLJoin && chain != null;
        chain = chain.next) {
            classes.add(((JQLJoin) chain).joinClass);
        }

        List<Entity<?>> entities = classes
                .stream()
                .map(clazz -> EntityRepository.getEntity(clazz))
                .collect(Collectors.toList());

        return entities;
    }
}
