package sep.jql.impls.statement.select;

import sep.entity.resolver.EntityRepository;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.attribute.Attribute;
import sep.entity.struct.field.Field;
import sep.jql.interfaces.statement.select.SelectExpression;

import java.util.ArrayList;
import java.util.List;

public class JQLSelectExpression implements SelectExpression {

    private List<Entity<?>> entities = new ArrayList<>();

    @Override
    public <E> void addEntity(Class<E> fromClass) {
        entities.add(EntityRepository.getEntity(fromClass));
    }

    @Override
    public String toSQLString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entity<?> entity : entities) {
            for (Field<?, ?> field : entity.getFields()) {
                Attribute<?> attribute = field.getAttribute();
                stringBuffer.append(attribute.toSQLString() + " AS " + attributeAlias(attribute));
                stringBuffer.append(", ");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(", "));
        return stringBuffer.toString();
    }

    private String attributeAlias(Attribute<?> attribute) {
        return "`" + attribute.toSQLString().replace("`", "") + "`";
    }
}
