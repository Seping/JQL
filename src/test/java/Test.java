
import sep.entity.resolver.EntityRepository;
import sep.entity.resolver.asm.AnnotationBasicASMResolver;
import sep.entity.struct.entity.Entity;
import sep.jql.*;
import 用来存放测试用的实体类.*;

import java.lang.invoke.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Test {

    @org.junit.Test
    public void test() {

        AppArea a = new AppArea();
        a.setSysIStatus(0);

        Entity<AppArea> entity = new AnnotationBasicASMResolver().resolve(AppArea.class);
        System.out.println(entity.getFields().get(17).getTombstoneValue());
    }

}
