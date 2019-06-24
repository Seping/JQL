# JQL
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
