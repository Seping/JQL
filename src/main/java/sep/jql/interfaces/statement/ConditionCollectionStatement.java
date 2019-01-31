package sep.jql.interfaces.statement;

import sep.jql.interfaces.condition.LogicalOperator;

public interface ConditionCollectionStatement extends CollectionStatement<CollectionStatement> {

    void add(CollectionStatement collectionStatement, LogicalOperator logicalOperator);

}
