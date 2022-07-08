# Annotations notes

## What is Annotation?
* Form of metadata. Provides data about program which is not part of program itself

## Annotation uses
* Information to the compiler
* Compile time processing
* deployment-time processing
* run-time processing

## Repeating Annotation
* Same annotation can be applied multiple times on same element. Introduced in Java SE 8
```
@Author(name="jack")
@Author(name="sparrow")
public void myBook() {---}
```

## Declaring Annotation
* Create annotation
```
public @interface ClassPreamble{
	String author() default "dummy value";
	String date();
	String[] reviewers();
}
```
* Using annotation
```
@ClassPreamble(author="john", date="8-Apr-2015" reviewers={"jack","jill"})
public class TestClass{

}
```

## Predefined annotation
### Annotations in java.lang package
* Depricated
* Override
* SafeVarargs - @SafeVarargs annotation, when applied to a method or constructor, asserts that the code does not perform potentially unsafe operations on its varargs parameter. When this annotation type is used, unchecked warnings relating to varargs usage are suppressed
* SuppressWarnings
* FunctionalInterface
	* Interface which has only one method
	* We have to use `@java.lang.FunctionalInterface` annotation to declare functional interface
	* Examples in java API
		* java.lang.Runnable { run();}
		* java.lang.Comparable{ compareTo(T o1); }
		* java.util.Comparator { compare(T o1, T o2); }
		* java.lang.AutoCloseable { close(); }
		* java.io.Closeable { close(); }
		* java.lang.reflect.InvocationHandler{ invoke(); } (used on dynamic proxies)
		* java.util.function.Function
		* java.util.function.Predicate
			
* Meta annotations
	* Annotation that apply to other annotations
	* There are 5 meta annotations declared in `java.lang.annotation` package
	* Generally used when defining custom annotations
	* Annotations in java.lang.annotation package
		* Documented
		* Inherited
		* Repeatable
		* Retention
		* Target
		
## java.lang.annotation.Documented
* When applied on specific element, that element should be documented by java doc tool
* The `@java.lang.annotation.Documented` annotation is used to signal to the JavaDoc tool that your custom annotation should be visible in the JavaDoc for classes using your custom annotation
```
@java.lang.annotation.Documented
public @interface MyAnnotation { ... }
@MyAnnotation
public class MyClass { ... }
```
* When generating JavaDoc for the MyClass -> @MyAnnotation is now included in the JavaDoc

## java.lang.annotation.Inherited
* Annotation type can be inherited from super class. When user queries for annotation type and that class don’t have annotation then super class will be queried for annotation type
* The `@java.lang.annotation.Inherited` annotation signals that a custom Java annotation used in a class should be inherited by subclasses inheriting from that class
```
@java.lang.annotation.Inherited
public @interface MyAnnotation { ... }

@MyAnnotation
public class MySuperClass { ... }
public class MySubClass extends MySuperClass { ... }
```
* In this example the class MySubClass inherits the annotation @MyAnnotation because MySubClass extends MySuperClass, and MySuperClass has a @MyAnnotation annotation

## java.lang.annotation.Repeatable
* Same annotation can be applied multiple times on same element. Introduced in JDK 8
* Refer 
	* [annotation](../annotations/src/main/java/com/repeating/annotation)
	* [BookTest](../annotations/src/test/java/com/repeating/annotation/BookTest.java)
	
## java.lang.annotation.Retention
* RetentionPolicy values
	* java.lang.annotation.RetentionPolicy.SOURCE
	* java.lang.annotation.RetentionPolicy.CLASS
	* java.lang.annotation.RetentionPolicy.RUNTIME
	
## java.lang.annotation.Target
* java.lang.annotation.ElementType
	* TYPE (class or field or method)
	* ANNOTATION_TYPE (custom annotation type)
	* PACKAGE
	* CONSTRUCTOR
	* FIELD
	* METHOD
	* PARAMETER
	* LOCAL_VARIABLE
