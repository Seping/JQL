# JQL

主要功能：这是一个可以让你用Java 8以上的方法引用来写SQL的框架。例如，假如你要写一句SQL： 
SELECT * FROM user 
        WHERE user.name = "John"

你可以这样来写： 
JQL.from(User.class) 
        .where((root1, conditionChain) -> { 
                return conditionChain 
                        .equal(root1.getAttribute(User::getName), "John"); 
        }); 
其中，User是user表对应的实体类，有get/set方法。

部件构成： 
1、实体类 
需要在类上标注@Table注解，表明这是与数据库表对应的实体类。实体类须有get/set方法，在get方法上可以用@Column注解标明该字段的特殊功能（插入时写默认值，逻辑删除标识等等）。

2、实体类解析器
实体类需要经EntityResolver解析，得到实体类的通用抽象Entity<t>，并存放于EntityRepository中。 我默认提供了一个用ASM解析的解析器，AnnotationBasicASMResolver。

3、JQL 
JQL就是用来写SQL的类了。很抱歉，目前只支持SELECT语句和MySQL的部分语法。。。

4、执行SQL 
在接口SQLExecutor中实现，查询结果以List<CompositeEntity<t>>返回。

5、结果 
结果封装为CompositeEntity<t>的形式。CompositeEntity是根据查询语句的join来封装的，例如，对于以下查询： SELECT * FROM user JOIN city ON city.name = user.city WHERE user.name = "John" 然后，得到了一个CompositeEntity<user>对象userResult，你可以用userResult.getJoinEntities(City.class)来获得这条user关联的所有city。 我默认提供了一个较为简陋的实现。

再杂谈一下吧。这个框架的具体实现其实很早就做出来了（master）分支，但是发现想扩展一个功能时存在了困难，就着手改造，把部件全部抽象化接口化。这才发现接口化、定义规范是最难的事情。当然，目前的组件结构我也不是很满意，主要在于复合条件链（ConditionChain）这个地方。有兴趣的大佬可以去看看代码，指点迷津一下。

以上，觉得有意思就star一下吧~
