package sep.entity.struct.entity;

import sep.entity.struct.field.Field;
import sep.entity.struct.field.special.Id;

import java.util.List;
import java.util.function.Supplier;

/**
 * 实体类的抽象类。
 */
public class Entity<T> {

    /**
     * 一个实体类包含以下要素：
     * 1. 对应的表名 tableName
     * 2. 对应的实体类 entityClass
     * 3. 成员（字段，属性）
     */
    private String tableName;
    private Class<T> entityClass;
    private List<Field> fields;
    private Supplier<T> supplier;

    private Id id;

    public Entity(Class<T> entityClass, String tableName, List<Field> fields, Supplier<T> supplier) {
        this.entityClass = entityClass;
        this.tableName = tableName;
        this.fields = fields;
        this.supplier = supplier;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableNameWithQuote() {
        return "`" + tableName + "`";
    }

    public List<Field> getFields() { return fields; }

    public Field getFieldByGetterName(String getterName) {
        return fields
                .stream()
                .filter(field -> field.getGetterName().equals(getterName))
                .findFirst()
                .get();
    }

    public T newInstance() {
        return supplier.get();
    }

    public Id getIdField() {
        if (id == null) {
            id = (Id) fields.
                    stream()
                    .filter(field -> field instanceof Id)
                    .findFirst()
                    .get();
        }
        return id;
    }
}
