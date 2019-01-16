package sep.jql;

import java.util.ArrayList;

public class JQL<T> {

    Class<T> mainClass;

    private JQL(Class<T> mainClass) {
        this.mainClass = mainClass;
    }

    public static <T> JQL<T> from(Class<T> fromClass) {
        return new JQL<>(fromClass);
    }



}
