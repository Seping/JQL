
import sep.entity.struct.field.attribute.ArbitraryAttribute;
import sep.entity.struct.field.attribute.Attribute;
import sep.entity.struct.field.root.Root;
import sep.jql.impls.component.*;
import sep.jql.impls.request.condition.builder.ConditionRequestBuilder;
import sep.jql.impls.request.condition.handler.JQLConditionRequestHandler;
import sep.jql.impls.statement.condition.JQLCompositeConditionExpression;
import sep.jql.interfaces.condition.ConditionConjunction;
import sep.jql.interfaces.condition.LogicalOperator;
import sep.jql.interfaces.request.condition.ArbitraryConditionRequest;
import sep.jql.interfaces.request.condition.SpecificConditionRequest;
import sep.jql.interfaces.statement.condition.CompositeConditionExpression;
import sep.jql.interfaces.statement.condition.ConditionExpression;
import sep.jql.interfaces.statement.condition.SingleConditionExpression;
import sep.jql.interfaces.statement.joinon.JoinOnStatement;
import sep.jql.interfaces.statement.query.QueryStatement;
import sep.jql.interfaces.statement.where.WhereStatement;
import 用来存放测试用的实体类.*;

import java.util.ArrayList;
import java.util.List;

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
                            .equal(root1.getAttribute(AppDbMaterial::getiNumber), 1)
                            .and()
                            .equal(root1.getAttribute(AppDbMaterial::getVcName), "abc");
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

        ArbitraryConditionRequest request1 = (ArbitraryConditionRequest) ConditionRequestBuilder.ofArbitraryEntity()
                .request((root, conditionConjunction) -> {
                    return conditionConjunction
                            .and()
                            .equal(root.getAttribute("getSysIStatus"), 1);
                });

        SpecificConditionRequest<AppDbMaterial> request2 = (SpecificConditionRequest<AppDbMaterial>) ConditionRequestBuilder.ofEntity(AppDbMaterial.class)
                .request((root, conditionConjunction) -> {
                    return conditionConjunction
                            .and()
                            .equal(root.getAttribute(AppDbMaterial::getDtQuaguaPeriod), 1);
                });

        new JQLConditionRequestHandler().handle(jql.queryStatement, request2);
        String s1 = jql.queryStatement.toSQLString();
        System.out.println(s1);
    }

}
