package sep.jql.condition;

import sep.sql.SQLConvertible;

public interface ConditionConjunction extends SQLConvertible {

    ConditionChain and();

    ConditionChain or();

}
