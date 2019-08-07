# JQL

JQL is a framework tries to make Java CRUD code more SQL-like and Java-like. You could code like

```
JQL
        .from(User.class)
        .join(City.class)
        .on((root1, root2, conditionChain) -> {
                return conditionChain
                        .equal(root1.getAttribute(User::getCityName), root2.getAttribute(City::getName));
        })
        .where((root1, conditionChain) -> {
                return conditionChain
                        .equal(root1.getAttribute(User::getUserName), "John Constantine")
                        .and()
                        .greater(root1.getAttribute(User::getBirthYear), 1953);
        });

```
It means

```
SELECT *
FROM user
	JOIN city ON user.city_name = city.name
WHERE user.username = 'John Constantine'
	AND user.birth_year > 1953
```

When using IDE with auto-completion, you could save the work of typing table name or column name word by word, thanks to the 'Method Reference' of Java 8.
