package sep.jql.impls.statement.joinon;

import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.joinon.JoinOnStatements;

import java.util.ArrayList;
import java.util.List;

public class JQLJoinOnStatements implements JoinOnStatements {

    private List<JoinOnStatement> joinOnStatementList = new ArrayList<>();

    @Override
    public List<JoinOnStatement> getJoinOnStatementList() {
        return joinOnStatementList;
    }

    @Override
    public void add(JoinOnStatement joinOnStatement) {
        joinOnStatementList.add(joinOnStatement);
    }

    @Override
    public JoinOnStatement getLast() {
        return joinOnStatementList.get(joinOnStatementList.size() - 1);
    }

    @Override
    public String toSQLString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (JoinOnStatement joinOnStatement : joinOnStatementList) {
            stringBuffer.append(joinOnStatement.toSQLString());
            stringBuffer.append("\r\n");
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf("\n"));
        return stringBuffer.toString();
    }

}
