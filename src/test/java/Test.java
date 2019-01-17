
import sep.entity.resolver.EntityRepository;
import sep.entity.resolver.asm.AnnotationBasicASMResolver;
import sep.entity.struct.entity.Entity;
import sep.entity.struct.field.Attribute;
import sep.entity.struct.field.Field;
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

        JQL.from(AppDbMaterial.class)
                .join(AppDbMaterialAddress.class)
                .on((root1, root2, conditionChain) -> {
                    return conditionChain
                            .equal(root1.getAttribute(AppDbMaterial::getiMaterialAddressId), root2.getAttribute(AppDbMaterialAddress::getiId))
                            .and()
                            .equal(root1.getAttribute(AppDbMaterial::getVcName), root2.getAttribute(AppDbMaterialAddress::getVcName));
                })
                .join(AppDbMaterialAddress.class, AppArea.class)
                .on((root1, root2, conditionChain) -> {
                    return conditionChain
                            .equal(root1.getAttribute(AppDbMaterialAddress::getiAreaId), root2.getAttribute(AppArea::getiId));
                })
                .where((root1, conditionChain) -> {
                    return conditionChain
                            .equal(root1.getAttribute(AppDbMaterial::getiNumber), 1);
                })
    }

}
