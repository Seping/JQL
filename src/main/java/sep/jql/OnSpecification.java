package sep.jql;


public interface OnSpecification<T, R> {

    void specific(Root<T> root1, Root<R> root2, ConditionBuilder conditionBuilder);

}
