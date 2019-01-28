package sep.sql;

public interface SQLAppendable<T extends SQLConvertible> extends SQLConvertible {

    void append(T t);

}
