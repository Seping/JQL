# JQL
主要功能：这是一个可以让你用Java 8以上的方法引用来写SQL的框架。例如，假如你要写一句SQL：
SELECT *
FROM user
WHERE user.name = "John"

你可以这样来写：
JQL.from(User.class)
	.where((root1, conditionChain) -> {
        return conditionChain
        .equal(root1.getAttribute(User::getName), "John");
    });
其中，User是user表对应的实体类，有get/set方法。

为什么要用“方法引用”呢？我只能说，初衷是为了能用IDE里的自动提示……

部件构成：
1、实体类
需要在类上标注@Table注解，表明这是与数据库表对应的实体类。实体类须有get/set方法，在get方法上可以用@Column注解标明该字段的特殊功能（插入时写默认值，逻辑删除标识等等）。

2、实体类解析器
实体类需要经EntityResolver解析，得到实体类的通用抽象Entity<T>，并存放于EntityRepository中。
我默认提供了一个用ASM解析的解析器，AnnotationBasicASMResolver。

3、JQL
JQL就是用来写SQL的类了。很抱歉，目前只支持SELECT语句和MySQL的部分语法。。。

4、执行SQL
在接口SQLExecutor中实现，查询结果以List<CompositeEntity<T>>返回。

5、结果
结果封装为CompositeEntity<T>的形式。CompositeEntity是根据查询语句的join来封装的，例如，对于以下查询：
SELECT *
FROM user
	JOIN city ON city.name = user.city
WHERE user.name = "John"
然后，得到了一个CompositeEntity<User>对象userResult，你可以用userResult.getJoinEntities(City.class)来获得这条user关联的所有city。
我默认提供了一个较为简陋的实现。
