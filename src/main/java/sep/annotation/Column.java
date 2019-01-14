package sep.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies a field mapping one column. Should be annotated on
 * the getter method of the field.
 *
 * @author Sep
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    /**
     * The name of column which the field maps.
     */
    String columnName();

    /**
     * The class which represents this kind of fields.
     * The value should be an implement of {@code Field}.
     *
     * @see sep.entity.struct.field.Field
     */
    Class field() default sep.entity.struct.field.BasicField.class;

    /**
     * Invalid when specifying the field class above. Replaced by the {@code getUpdateValue()} method of the field class.
     * Specifies the value written into database when executing update, ignoring
     * the value the field storing.
     */
    String updateValue() default "";

    /**
     * Invalid when specifying the field class above. Replaced by the {@code getInsertValue()} method of the field class.
     * Specifies the value written into database when executing insert, ignoring
     * the value the field storing.
     */
    String insertValue() default "";

    /**
     * Invalid when specifying the field class above. Replaced by the {@code getQueryValue()} method of the field class.
     * Specifies a value which the field should equal when the query is executed.
     */
    String queryValue() default "";

    /**
     * Invalid when specifying the field class above. Replaced by the {@code getTombstoneValue()} method of the field class.
     * Specifies a value which the field should be set when the logically delete is executed.
     */
    String tombstoneValue() default "";
}
