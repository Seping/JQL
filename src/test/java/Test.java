import sep.entity.用来存放测试用的实体类.*;
import sep.jql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void test() {

        JQLStatement jqlStatement = JQL.from(AppDbMaterial.class)
                .join(AppDbMaterialAddress.class)
                .on((root1, root2, conditionBuilder) -> {
                    conditionBuilder
                            .equal(root1.getAttribute(AppDbMaterial::getiMaterialAddressId), root2.getAttribute(AppDbMaterialAddress::getiId))
                            //.and()
                            //.equal(root2.getAttribute(AppDbMaterialAddress::getiStatus), 0)
                            ;
                })
                .join(AppDbMaterialAddress.class, AppArea.class)
                .on((root1, root2, conditionBuilder) -> {
                    conditionBuilder
                            .equal(root1.getAttribute(AppDbMaterialAddress::getiAreaId), root2.getAttribute(AppArea::getiId))
                            .and()
                            .equal(root2.getAttribute(AppArea::getSysIStatus), 0);
                })
                .join(AppDbMaterialAddress.class, AppDbMaterialAddressRel.class)
                .on((root1, root2, conditionBuilder) -> {
                    conditionBuilder
                            .equal(root1.getAttribute(AppDbMaterialAddress::getiId), root2.getAttribute(AppDbMaterialAddressRel::getiMaterialAddressId));
                })
                .join(AppDbMaterialAddressRel.class, AppContactor.class)
                .on((root1, root2, conditionBuilder) -> {
                    conditionBuilder
                            .equal(root1.getAttribute(AppDbMaterialAddressRel::getiContactorId), root2.getAttribute(AppContactor::getiId));
                })
                .where((root, conditionBuilder) -> {
                    conditionBuilder
                            .equal(root.getAttribute(AppDbMaterial::getSysIStatus), 0);
                })
                .orderBy(AppDbMaterial::getDtQuaguaPeriod)
                //.limit(0 ,1)
                .end();
        
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.7.237:3306/emplus2?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8",
                    "emt", "chinaemt");
            long t1 = System.currentTimeMillis();
            List<ComplexEntity<AppDbMaterial>> list = JQLExecutor.execute(jqlStatement, connection);
            System.out.println("time: " + (System.currentTimeMillis() - t1));
            ComplexEntity<AppDbMaterial> complexEntity = list.get(0);
            List<AppContactor> contactors = complexEntity.getJoinEntities(AppContactor.class);
            System.out.println(contactors.size());
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        String s = SQLCreator.createSQL(jqlStatement);
        System.out.println(s);



        /*Entity<AppContactor> entity = new HibernateASMResolver().resolve(AppContactor.class);
        Field field = entity.getFields().get(0);
        AppContactor contactor = entity.newInstance();
        field.setValue(contactor, 21);*/

    }

}
