package sep.jql.condition;

import sep.entity.struct.entity.Entity;

public interface SingleAttributeSpecification<T> {

    ConditionChain.Conjunction specific(Entity<T> entity, ConditionChain conditionChain);

}
