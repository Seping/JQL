package sep.jql;


import java.util.ArrayList;
import java.util.List;

public class ConditionBuilder {

    List<Condition> conditions = new ArrayList<>();
    List<ConjunctionBuilder.Conjunction> conjunctions = new ArrayList<>();

    public ConjunctionBuilder equal(Attribute<?> attribute1, Object attribute2) {
        Condition condition = new Condition(attribute1, attribute2, Condition.Operator.EQUAL);
        conditions.add(condition);
        return new ConjunctionBuilder(this);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int j = 0;
        int size1 = conditions.size();
        int size2 = conjunctions.size();
        while (i < size1) {
            stringBuffer.append(conditions.get(i).toString());
            i++;
            if (i < size1 && j < size2) {
                stringBuffer.append("\r\n\t\t");
                stringBuffer.append(conjunctions.get(j).conjunction);
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }
}
