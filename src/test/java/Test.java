
import sep.entity.struct.field.root.ArbitraryRoot;
import sep.entity.struct.field.root.Root;
import sep.jql.impls.component.JQL;
import sep.jql.impls.component.Order;
import sep.jql.impls.request.ConditionRequestBuilder;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.request.condition.ArbitraryConditionRequest;
import sep.jql.interfaces.request.condition.ConditionRequest;
import sep.jql.interfaces.request.condition.SpecificConditionRequest;
import 用来存放测试用的实体类.*;

public class Test {

    @org.junit.Test
    public void test() {

        JQL<AppDbMaterial> jql = JQL.from(AppDbMaterial.class);

        jql
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
                .orderBy(AppDbMaterial::getDtQuaguaPeriod, Order.DESC)
                .limit(0, 1);

        String s = jql.queryStatement.toSQLString();
        System.out.println(s);

        SpecificConditionRequest<AppDbMaterial> conditionRequest = new SpecificConditionRequest<AppDbMaterial>() {
            @Override
            public ConditionConjunction appendCondition(Root<AppDbMaterial> root, ConditionConjunction conditionConjunction) {
                return conditionConjunction.and().equal(root.getAttribute(AppDbMaterial::getDtQuaguaPeriod), 1);
            }
        };

        ConditionRequestBuilder.ofArbitraryEntity()
                .request((root, conditionConjunction) -> {
                    return conditionConjunction
                            .and()
                            .equal(root.getAttribute("sys_i_status"), 1);
                });

        ConditionRequestBuilder.ofEntity(AppDbMaterial.class)
                .request((root, conditionConjunction) -> {
                    return conditionConjunction
                            .and()
                            .equal(root.getAttribute(AppDbMaterial::getDtQuaguaPeriod), 1);
                });
    }

}
