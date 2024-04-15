This project aims to demonstrate an issue in Spring Data JPA 3.1.X

When you define a JPL that contains UNION clauses, and this JPL is pageable and sorted, an exception is thrown because the SQL is not well formed.

If you run the Spring Boot application, you will get the exception like this:

Caused by: org.hibernate.query.sqm.ParsingException: line 1:62 mismatched input 'ascUNION' expecting {<EOF>, ',', '.', '[', '+', '-', '*', '/', '%', '||', ASC, BY, DAY, DESC, EPOCH, FETCH, HOUR, LIMIT, MINUTE, MONTH, NANOSECOND, NULLS, OFFSET, QUARTER, SECOND, WEEK, YEAR}
	at org.hibernate.query.hql.internal.StandardHqlTranslator$1.syntaxError(StandardHqlTranslator.java:46) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.antlr.v4.runtime.ProxyErrorListener.syntaxError(ProxyErrorListener.java:41) ~[antlr4-runtime-4.10.1.jar:4.10.1]
	at org.antlr.v4.runtime.Parser.notifyErrorListeners(Parser.java:543) ~[antlr4-runtime-4.10.1.jar:4.10.1]
	at org.antlr.v4.runtime.DefaultErrorStrategy.reportInputMismatch(DefaultErrorStrategy.java:327) ~[antlr4-runtime-4.10.1.jar:4.10.1]
	at org.antlr.v4.runtime.DefaultErrorStrategy.reportError(DefaultErrorStrategy.java:139) ~[antlr4-runtime-4.10.1.jar:4.10.1]
	at org.hibernate.grammars.hql.HqlParser.statement(HqlParser.java:361) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.hibernate.query.hql.internal.StandardHqlTranslator.parseHql(StandardHqlTranslator.java:127) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.hibernate.query.hql.internal.StandardHqlTranslator.translate(StandardHqlTranslator.java:77) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.hibernate.query.internal.QueryInterpretationCacheStandardImpl.createHqlInterpretation(QueryInterpretationCacheStandardImpl.java:165) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.hibernate.query.internal.QueryInterpretationCacheStandardImpl.resolveHqlInterpretation(QueryInterpretationCacheStandardImpl.java:147) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.hibernate.internal.AbstractSharedSessionContract.interpretHql(AbstractSharedSessionContract.java:741) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	at org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:786) ~[hibernate-core-6.2.22.Final.jar:6.2.22.Final]
	... 58 common frames omitted
