package sep.jql;

import sep.util.SQLStringUtil;

public class Condition<T> {

    private Attribute<T> attribute1;
    private String operator;
    private Object attribute2;

    public Condition(Attribute<T> attribute1, Object attribute2, Operator operator) {
        this.attribute1 = attribute1;
        this.operator = operator.operator;
        this.attribute2 = attribute2;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(SQLStringUtil.attribute2String(attribute1));

        stringBuffer.append(" ");
        stringBuffer.append(operator);
        stringBuffer.append(" ");

        if (attribute2 instanceof Attribute<?>) {
            stringBuffer.append(SQLStringUtil.attribute2String((Attribute<?>)attribute2));
        } else {
            stringBuffer.append(SQLStringUtil.toSQLValueString(attribute2));
        }

        return stringBuffer.toString();
    }

    enum Operator {
        EQUAL("=");

        private String operator;
        Operator(String operator) {
            this.operator = operator;
        }
    }
}
