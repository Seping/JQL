import sep.entity.struct.field.BasicField;
import sep.util.SQLStringUtil;
import 用来存放测试用的实体类.AppArea;

public class SomeField extends BasicField<AppArea, Integer> {

    @Override
    public Integer getUpdateValue() {
        return SQLStringUtil.stringToSQLValue("123", Integer.class);
    }
}
