package sep.entity.struct.entity;

import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EntityImpl<T> implements Entity<T> {

    private Class<T> entityType;
    private String tableName;
    private List<Field<T, ?>> fields = new ArrayList<>();
    private Supplier<T> newInstanceSupplier;

    public EntityImpl(Class<T> entityType, String tableName, Supplier<T> newInstanceSupplier) {
        this.entityType = entityType;
        this.tableName = tableName;
        this.newInstanceSupplier = newInstanceSupplier;
    }

    @Override
    public Class<T> getEntityType() {
        return entityType;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public List<Field<T, ?>> getFields() {
        return new ArrayList<>(fields);
    }

    @Override
    public void addField(Field<T, ?> field) {
        fields.add(field);
    }

    @Override
    public Field<T, ?> getFieldByAttributeName(String attributeName) {
        return fields
                .stream()
                .filter(field -> field.getAttributeName().equals(attributeName))
                .findFirst()
                .get();
    }

    @Override
    public Attribute<T> getAttribute(Attribute<T> attribute) {
        return attribute;
    }

    @Override
    public Attribute<T> getAttributeByName(String attributeName) {
        return getFieldByAttributeName(attributeName).getAttribute();
    }

    @Override
    public T newInstance() {
        return newInstanceSupplier.get();
    }

    @Override
    public String toSQLString() {
        return "`" + tableName + "`";
    }
}
