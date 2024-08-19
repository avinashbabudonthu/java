### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Passing null values
* We cannot stub method passing null value then use `Mockito.isNull()`
* Sample code
```
import org.mockito.Mockito;

Mockito.when(employeeDao.getEmployeeNames(Mockito.isNull())).thenReturn(new ArrayList<>());
or
Mockito.when(employeeDao.getEmployeeNames(Mockito.eq(null))).thenReturn(new ArrayList<>());
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)