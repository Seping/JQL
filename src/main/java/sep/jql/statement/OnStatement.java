package sep.jql.statement;

import sep.jql.condition.ConditionConjunction;

public interface OnStatement<M, A, B> extends Statement {

    ConditionConjunction getTheEndOfCondition();

}
