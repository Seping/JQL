package sep.jql;

public class ConjunctionBuilder {

    ConditionBuilder conditionBuilder;
    ConjunctionBuilder(ConditionBuilder conditionBuilder) {
        this.conditionBuilder = conditionBuilder;
    }

    public ConditionBuilder and() {
        //conditions.add(condition);
        conditionBuilder.conjunctions.add(Conjunction.AND);
        return conditionBuilder;
    }

    enum Conjunction {
        AND("AND"), OR("OR");

        String conjunction;
        private Conjunction(String conjunction) {
            this.conjunction = conjunction;
        }
    }
}

