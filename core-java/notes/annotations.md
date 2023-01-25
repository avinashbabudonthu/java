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
	* java.lang.annotation.RetentionPolicy.SOURCE – The marked annotation is retained only in the source level and is ignored by the compiler
	* java.lang.annotation.RetentionPolicy.CLASS – The marked annotation is retained by the compiler at compile time, but is ignored by the Java Virtual Machine (JVM)
	* java.lang.annotation.RetentionPolicy.RUNTIME – The marked annotation is retained by the JVM so it can be used by the runtime environment
	
## java.lang.annotation.Target
* `@java.lang.annotation.Target` annotation marks another annotation to restrict what kind of Java elements the annotation can be applied to. A target annotation specifies one of the following element types as its value:
* ElementType.ANNOTATION_TYPE can be applied to an annotation type.
* ElementType.CONSTRUCTOR can be applied to a constructor.
* ElementType.FIELD can be applied to a field or property.
* ElementType.LOCAL_VARIABLE can be applied to a local variable.
* ElementType.METHOD can be applied to a method-level annotation.
* ElementType.PACKAGE can be applied to a package declaration.
* ElementType.PARAMETER can be applied to the parameters of a method.
* ElementType.TYPE can be applied to any element of a class.

------
# Type Annotations and Pluggable Type Systems
* Before the Java SE 8 release, annotations could only be applied to declarations. As of the Java SE 8 release, annotations can also be applied to any type use. This means that annotations can be used anywhere you use a type. A few examples of where types are used are class instance creation expressions (new), casts, implements clauses, and throws clauses. This form of annotation is called a type annotation
* Examples
* Class instance creation expression:
```
new @Interned MyObject();
```
* Type cast:
```
myString = (@NonNull String) str;
```
* implements clause:
```
class UnmodifiableList<T> implements @Readonly List<@Readonly T> { ... }
```
* Thrown exception declaration:
```
void monitorTemperature() throws @Critical TemperatureException { ... }
```
------
* An Introduction to Annotations and Annotation Processing in Java - https://reflectoring.io/java-annotation-processing/