package sep.dao;

import sep.jql.*;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

public class BaseDao<T> {

    private Class<T> type = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public Collection<T> save(Collection<T> collection) {
        return JQLExecutor.executeSave(collection, type);
    }

    public List<ComplexEntity<T>> query(JQLBuilder<T> jqlBuilder) {
        JQLStatement<T> jqlStatement = jqlBuilder.build(JQL.from(type));
        return JQLExecutor.executeQuery(jqlStatement);
    }
}
