# Materials in study order
* Udemy - Maven Crash Course, JUnit and Mockito Crash Course
* https://www.baeldung.com/mockito-annotations#enable-annotations
------
# Notes
* What is Mockito
	* Mockito is Mocking framework to use in Junit
* Mockito limitations
	* 	we cannot mock final methods. You can stub the call and the runtime will not complain, but we will receive an assertion failure if you expect the mocked result to be returned
	* We cannot mock private methods.
	* we cannot mock static methods
* Steps to implement mockito
	* Declare this annotation at test class level`@RunWith(org.mockito.runners.MockitoJunitRunner.class)`
	* To create injected object annotate them with this `@Mock private ProductDo productDo;`
	* To inject created mock object into target object `@InjectMocks private ProductBo productBo;`
	* Annotate init method with annotation `@Before`
	* In the init method `MockitoAnnotations.initMocks(this);`
	* Annotate test method with @Test annotation
* Create stub for method
```
List<Product> products = java.util.Arrays.asList(product1, product2);
org.mockito.Mockito.stub(productDo.getProducts(org.mockito.Matchers.anyInt())).toReturn(products);
(or)
org.mockito.Mockito.when(productDo.getProducts(org.mockito.Matchers.anyInt())).toReturn(products);
(or)
org.mockito.Mockito.when(mockOrderDao.findOrder(orderId)).thenReturn(orderFixture);
```
* create mock without annotation of dependency class
```
OrderDao mockOrderDao = org.mockito.Mockito.mock(OrderDao.class);
```
* Verification. To assert that particular methods were called with matched set of inputs. 
```
org.mockito.Mockito.verify(mockOrderDao).findOrder(orderId);
```
* If we have to mock class which is implementing multiple interfaces then in that case we need to use MockSettings class to create mock
```
org.mockito.MockSettings (I)
org.mockito.internal.creation.MockSettingsImpl (c )
MockSettings mockSettings = Mockito.withSettings();
OrderDao mockOrderDao = Mockito.mock(OrderDao.class, mockSettings);
```
* This method will accept variable number of interfaces, which the resulting mock will implement
```
MockSettings.extraInterfaces(.. )

public class OrderUtil implements OrderFilter, OrderTransformer{ --- }
class OrderServiceImpl{
OrderTransformer orderTransformer = …;
  public List<String> getOrderSummary(){
    if(orderTransformer instanceof OrderFilter) { … }
  }
}

OrderTransformer mockOrderTransformer = Mockito.mock(OrderTransformer.class, mockSettings.extraInterfaces(OrderFilter.class) );
```
* Making mock to implement Serializable interface
```
MockSettings.serializable(…);
```
* allows you to provide a descriptive name to be logged when any verification against mock fails
```
MockSettings.name(...)
```
* Mockito.when(..)
	* return OnGoingStub<T>, specifies how the invocation behaves. This is generic type
	* the type of the instance is derived from the return type of the operation being called on the mock. We then use instance of OnGoingStub to specify what to return upon invocation of the operation
* OnGoingStub contains the following operations
	* thenReturn(..)
	* thenThrow(..)
	* thenCallRealMethod(..)
	* thenAnswer(..)
	* doThrow(..)
* thenReturn(..)
	* return an object or value based on the return type of the method being stubbed
* thenThrow(..)
	* provides means for testing exception being thrown by method under test
	* This method expects an instance of an exception as the parameter and stores it to later being thrown during execution of method
```
Mockito.when(mockService.getEmployeeList()).thenThrow(new NoRecordsException("no records found"));
```
* void methods
	* Mocking void methods do not work with OnGoingStub<T>
	* We don’t need to mock methods returning void because there is nothing we need to return as method execution that we can stub. But we have situation like method with void can throw an exception. To test this situation we need to use doThrow(..) method
* doThrow(..)
	* returns an instance of org.mockito.Stubber rather than org.mockito.OnGoingStub
```
org.mockito.Stubber stubber = Mockito.doThrow(new EmployeeInsertException("can not insert new employee"));
stubber.when(employeeServiceMock.insertEmployee(employeeFixture) );

org.mockito.stubbing.Stubber stubber = Mockito.doThrow(new EmployeeInsertException("can not insert new employee"));
stubber.when(employeeServiceMock).insertEmployee(employeeFixture);
```
* thenCallRealMethod(..)
	* To call real method on stubbing
```
Mockito.when(mockService.getEmployeeList()).thenCallRealMethod();
```
* Answering allows you to provide a means to conditionally respond based on mock operation parameters
	* thenAnswer(..)
		* this is used for argument matching means return different values based on arguments to method being mocked
```
Mockito.when( mockService.insertEmployee(Mockito.any(Employee.class)) ).thenAnswer(new Answer(){
   Object answer(InvocationOnMock invocation) { ----- }
});
```
* Mockito.verify()
	* Used to verify whether mock method is being called or not
	* Allows to verify how many time mock method is being called in method under test
```
Mockito.when(employeeServiceMock.getEmployee(empId)).thenReturn(employeeFixture);
//verification
Mockito.verify(employeeServiceMock).getEmployee(empId);

Mockito.verify(employeeServiceMock, Mockito.times(2)).getEmployee(empId);
```
* How many times mock method being called in method under test
```
VerificationSettings.times(n)
```
* Mock method must be called at least once and also can be called more than once
```
atLeastOnce()
```
* minimum number of times that mock method must be called in method under test and also can be called more than n time but not less than n times
```
atLeast(n)
```
* maximum number of time that mock method can be called in method under test
```
atMost(n)
```
* mock operation should never be called by method under test. Generally used while testing alternate paths of code
```
never()
```
* declares that mock should have absolutely no interaction throughout the execution of the test method
```
Mockito.verify(..).zeroInteractions()
```
* there may have been certain operations called on the mock, but no others were expected in the alternative paths of code
```
Mockito.verify(..).noMoreInteractions()
```
* Argument Matchers
	* provides extra control of stubs and verification of calls. Argument matchers allow alternatives for matching based on equals method often providing a more generic specification of a method stub by explicitly declaring the matching strategy
	* org.mockito.Matchers
	* org.mockito.Mockito
```
Mockito.mock(employeeServiceMock.getEmployee(Matchers.anyString()) ).thenReturn(employeeFixture);
if method has 2 arguments: Mockito.mock(employeeServiceMock.findByIdAndName( Matchers.eq("1L"), Matchers.anyString()) ) .thenReturn(employeeFixture);
```
* Different methods in org.mockito.Matchers
	* Matchers is base class of Mockito class (i.e public class Mockito extends Matchers )
	* Matchers.eq(..)
	* Matchers.any(String.class) (or) ((String)Matchers.any())
	* Matchers.anyInt()
	* Matchers.anyDouble()
	* (Set<String>)Matchers.anySet() (or) Matchers.anySetOf(String.class)
	* Matchers.eq("Johny");
	* Matchers.contains("ohn");
	* Matchers.startsWith("Jo");
	* Matchers.endsWith("ny");
	* Matchers.match("^(Jo|Ko)hny");
	* Matchers.same(ref)
	* Matchers.refEq(ref)
	* Matchers.refEq(ref, "excludeField");
* Stubbing consecutive calls with different responses
```
Mockito.mock(employeeServiceMock.getEmployee(Matchers.anyInt())).thenThrow(NoObjectException.class).thenReturn(employeeFixture);
```
* InOrder verifier
	* Now in method under test if methods getEmployee, getSalary are not executed in the order specified above then test will fail
```
InOrder inOrderVerifier = Mockito.inOrder(employeeServiceMock, financeServiceMock);
inOrderVerifier.verify(employeeServiceMock).getEmployee(employeeFixture);
inOrderVerifier.verify(financeServiceMock).getSalary(salaryFixture);
```
* Partial Mocks
	* We can mock interfaces and classes. If we mock certain operation on interfaces and mock certain operation on class then that is calles Partial Mocks
* Mock vs Spy
	* We can mock invocations using mock or spy
* Spy
	* Spy wraps an existing instance of an object inside the proxy and its default nature is to call the real method
	* The method invocations are only mocked when you explicitely stub the call. In this case proxy knows to bypass the real method call
------
# Mock Autowired Value Field In Spring With Mockito
* Use below code in `@Before` method
```
ReflectionTestUtils.setField(bean, "fieldName", "value");	
```
------
# jdbcTemplate object mocking and stubbing
* `queryForObject` method - this will give ambiguity compilation error
* solved using below method
	* Mockito.eq
------
# Argument Captures
* If method under test creating an object but does not returning then how to test the object whether it is constructed correctly? This can be done using argument captures
* ArgumentCaptor allows you to capture the actual object passed into the mock
```
Mockito.mock(mockOrderDao.insert(Mockito.any(OrderEntity.class)) ).thenReturn(1);

// original method in which orderDao.insert(orderEntity) is getting called. With id=1 OrderEntity object will be created
String orderNumber = this.target.openNewOrder(1);

ArgumentCaptor<OrderEntity> orderEntityCaptor = ArgumentCaptor.forClass(OrderEntity.class);
Mockito.verify(mockOrderDao).insert(orderEntityCaptor.capture() );
OrderEntity orderEntity = orderEntityCaptor.getValue();
Assert.assertEqual(1, orderEntity.getCustomerId() );
```
------
# How to resolve Unneccessary Stubbing exception
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