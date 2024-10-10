### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Using custom primary key generator on entities
* Create class `PrimaryKeyGenerator` extends `org.hibernate.id.IdentifierGenerator`
```
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

@Slf4j
public class PrimaryKeyGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
        return method2();
    }

    private static String method1() {
        try {
            return String.valueOf(Math.abs(System.nanoTime() + new Random().nextLong()));
        } catch (Exception e) {
            // Implement ErrorsEnum and update below messages
            log.error("Exception while generating primary key", e);
            return String.valueOf(UUID.randomUUID().timestamp());
        }
    }

    private static String method2() {
        return UUID.randomUUID().toString();
    }

}
```
------
# Before hibernate 6.0
* Define below annotations on entity id property
```
@Id
@org.hibernate.annotations.GenericGenerator(name = "custom-primary-key-generator", type = PrimaryKeyGenerator.class)
@jakarta.persistence.GeneratedValue(generator = "custom-primary-key-generator")
@Column(name = "id")
private String id;
```
------
# From 6.0
* Create annotation using `PrimaryKeyGenerator`
```
import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IdGeneratorType(PrimaryKeyGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface MyPrimaryKeyGenerator {
    String name();
}
```
* Use above annotation on entity id property
```
@Id
@MyPrimaryKeyGenerator(name = "custom-primary-key-generator")
@Column(name = "id")
private String id;
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)