package sep.jql.interfaces.able;

public interface Joinable<M> {

    <A, B> Onable<M, A, B> join(Class<A> rootClass, Class<B> joinClass);

}
