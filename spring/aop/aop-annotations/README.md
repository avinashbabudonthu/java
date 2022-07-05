# Dependency Injection using Xml

## Create project using maven
```
mvn archetype:generate -DgroupId=aop.annotations -DartifactId=aop-annotations -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Examples
* [Before Aspect](#before-aspect)
* [Before Aspect with JoinPoint](#before-aspect-with-joinpoint)
* [After Aspect with JoinPoint](#after-aspect-with-joinpoint)
* [AfterThrowing Aspect](#afterthrowing-aspect)
* [AfterReturning Aspect](#afterreturning-aspect)
* [Around Aspect](#around-aspect)
* [Method level Annotation Aspect](#method-level-annotation-aspect)
* [Reuse point cut expressions](#reuse-point-cut-expressions)


## Before aspect
* package - **before.aspect**
* Create Before aspect which executes before **findStudent()** method
* **findStudent()** method present in **StudentRepository**, **StudentService**
* Create aspect **LoggingAspect** with **@Before** annotation
* Aspect
```
@Before("execution(Student findStudent())")
```
* Execute **before.aspect.App** - we will see 2 logs printed in console
* Integration test - **src/test/java/before.aspect.IntegrationTest**
* Problem in this example is - we don't know **class**, **method** names for which aspect executed
* We can get class, method names using **JoinPoint**. Refer - **before.aspect.joinpoint**

## Before Aspect with JoinPoint
* package **joinpoint.before.aspect**
* Create Before aspect which executes before **findStudent()** method
* **findStudent()** method present in **StudentRepository**, **StudentService**
* Create aspect **LoggingAspectJoinPoint** with **@Before** annotation
* Aspect
```
@Before("execution(Student2 findStudent())")
```
* Execute **joinpoint.before.aspect.App** - we will see 2 logs printed in console
* Integration test - **src/test/java/joinpoint.before.aspect.IntegrationTest**

## After Aspect with JoinPoint
* Package **after.aspect**
* Create After aspect which executes after **findStudent()** method
* **findStudent()** method present in **StudentRepository**, **StudentService**
* Create aspect **AfterAspectAfterJoinPoint** with **@After** annotation
* Aspect
```
@After("execution(Student3 findStudent())")
```
```
@After("execution(* *(..))")
```
* Execute **after.aspect.App**
* Integration test - **src/test/java/after.aspect.IntegrationTest**

## AfterThrowing Aspect
* Package **after.throwing**
* Create AfterThrowing aspect - **AfterThrowingAspectJoinPoint**
* **Aspect method parameter name** and @AfterThrowing annotation's **throwing** attribute value should be same
* Throw **RuntimeException** from **StudentRepository**
* Main class - **after.throwing.App**
* Integration test class - **src/test/java/after.throwing.IntegrationTest**

## AfterReturning Aspect
* Package **afterreturn.aspect**
* Create AfterReturningAspect asect - **AfterReturningAspect**
* Aspect method parameter name and @AfterRetrurning annotation's **returning** attribute value should be same
* Return **String** from **StudentRepository.findStudent** method
* Main class - **afterreturn.aspect.App**
* Integration test class - **src/test/java/afterreturn.aspect.IntegrationTest**

## Around Aspect
* Package - **around.aspect**
* Create around aspect - **AroundAspect**
* Main class - **around.aspect.App**
* Integration test class - **src/test/java/around.aspect.IntegrationTest**

## Method level Annotation aspect
* Package - **method.level.annotation.aspect**
* Aspect to executes before method with method level annotation - **TestAnnotation**
* Create around aspect - **MethodLevelAnnotationAspect**
* Main class - **method.level.annotation.aspect.App**
* Integration test class - **src/test/java/method.level.annotation.aspect.IntegrationTest**

## Reuse point cut expressions
* Package - **pointcut.annotation**
* Reuse point cut expression using **@Pointcut** annotation
* Define class - **AppPointCuts**
* Define method - **AppPointCuts.testAnnotationPointcut**
* Declare **@Pointcut** annotation on method
* Declare point cut method with advice - **MethodLevelAnnotationAspect**
* Main class - **pointcut.annotation.App**
* Integration test - **pointcut.annotation.IntegrationTest**

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package