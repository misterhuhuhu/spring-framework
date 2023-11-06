编译时 织入
-
- 使用 aspectj-maven-plugin

Spring中切入点表达式简介
-
- 使用方法
1. @Pointcut
```java
@Pointcut("within(@org.springframework.stereotype.Repository *)")
public void repositoryClassMethods() {}
```
2. 提供了一个名称来引用该切入点
```
@Around("repositoryClassMethods()")
public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {}
```
指示符
=
- execution
- within
- this 
- target
- args
- @target
- @args
- @within
- @annotation

指示符组合
=
```
@Pointcut("@target(org.springframework.stereotype.Repository)")
public void repositoryMethods() {}

@Pointcut("execution(* *..create*(Long,..))")
public void firstLongParamMethods() {}

@Pointcut("repositoryMethods() && firstLongParamMethods()")
public void entityCreationMethods() {}
```