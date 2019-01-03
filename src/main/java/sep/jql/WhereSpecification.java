package sep.jql;

public interface WhereSpecification<T> {

    void specific(Root<T> root, ConditionBuilder conditionBuilder);

}
