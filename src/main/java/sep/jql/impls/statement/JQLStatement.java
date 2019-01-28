package sep.jql.impls.statement;

import sep.jql.interfaces.statement.*;
import sep.sql.SQLAppendable;

import java.util.ArrayList;
import java.util.List;

public class JQLStatement implements Statement, SQLAppendable<Statement> {

    SelectStatement selectStatement;
    FromStatement fromStatement;
    List<JoinStatement> joinStatements = new ArrayList<>();
    List<OnStatement> onStatements = new ArrayList<>();
    WhereStatement whereStatement;
    OrderByStatement orderByStatement;
    LimitStatement limitStatement;

    @Override
    public void append(Statement statement) {

    }

    @Override
    public String toSQLString() {
        return null;
    }
}
