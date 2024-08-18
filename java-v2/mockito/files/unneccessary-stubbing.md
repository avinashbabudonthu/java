### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Unnecessary Stubbing Junit 4 Junit 5
* Junit 4 in RunWith
```
@RunWith(MockitoJUnitRunner.Silent.class) 
```
* Junit 4 using rule approach
```
@Rule
public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);

@Rule
public MockitoRule rule = MockitoJUnit.rule().silent();
```
* Junit 4 while stubbing
```
Mockito.lenient().when(mockedService.getUserById(any())).thenReturn(new User());
```
* Junit 5
```
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class JUnit5MockitoTest {}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)