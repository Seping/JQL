package sep.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies the id field. An id field means a field mapping an int-type column
 * which is primary key and auto generating. This annotation should be annotated
 * on the getter method of the id field.
 *
 * @authod Sep
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    /**
     * The name of column which the field maps.
     */
    String columnName();
}
