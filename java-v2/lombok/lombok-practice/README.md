### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Lombok Practice Examples
------
# lombok.Builder annotation
* If we add `lombok.Builder` annotation on class then we will get builder pattern like below. Refer [Student](src/main/java/com/java/model/Student.java) and [LombokTest](src/test/java/com/java/LombokTest.java)
```
Student student = Student.builder()
.id(1)
.name("a")
.joiningDate(new Date())
.build();
```
* If we want to update specific properties of existing object then use `toBuilder=true` in `lombok.Builder` annotation Refer [Student](src/main/java/com/java/model/Student.java)
```
@Builder(toBuilder = true)
```
---
# lombok.experimental.FieldDefaults annotation
* If we add `@FieldDefaults(level = AccessLevel.PRIVATE)` then all fields are marked as private
* FieldsDefaults documentation. FieldDefaults has 2 properties - `level`, `makeFinal`
  * If makeFinal is true, then each (instance) field that is not annotated with @NonFinal will have the final modifier added.
  * If level is set, then each (instance) field that is package private (i.e. no access modifier) and does not have the @PackagePrivate annotation will have the appropriate access level modifier added.

------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)