package sep.jql.able;

public interface SingleJoinable<M> {

    <B> Onable<M, M, B> join(Class<B> joinClass);

}
