package sep.jql.impls.statement;

import sep.entity.struct.field.Attribute;
import sep.jql.interfaces.statement.SelectExprStatement;

public class JQLSelectExprStatement implements SelectExprStatement {

    Attribute<?> leftOperand;
    String operator = "AS";
    String rightOperand;

    @Override
    public void setLeftOperand(Attribute<?> leftOperand) {
        this.leftOperand = leftOperand;
    }

    @Override
    public void setOperator(String operator) {

    }

    @Override
    public void setRightOperand(String rightOperand) {
        this.rightOperand = rightOperand;
    }

    @Override
    public Attribute<?> getLeftOperand() {
        return leftOperand;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public String getRightOperand() {
        return rightOperand;
    }

    @Override
    public String toSQLString() {
        return null;
    }
}
