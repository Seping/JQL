package sep.jql.able;

import sep.sql.SQLConvertible;

public interface Onable<M, A, B> extends SQLConvertible {

    interface On<M, C, D> extends Whereable<M>, Joinable<M> {

    }

}
