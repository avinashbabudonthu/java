# Materials in study order
* Udemy - Maven Crash Course, JUnit and Mockito Crash Course
* http://www.mkyong.com/tutorials/junit-tutorials/
* box/junit/pdf file
------
# Junit Features
* Fixtures
	* Fixtures is a fixed state of a set of objects used as a baseline for running tests
	* The purpose of a test fixture is to ensure that there is a well known and fixed environment in which tests are run so that results are repeatable
	* It includes setup() and tearDown() methods
* Asserts
* Test setup and teardown
* Exception testing
* Test suite
	* Test suite means bundle a few unit test cases and run it together
	* In JUnit, both `@org.junit.runner.RunWith` and `@org.junit.runners.Suite` and `@org.junit.runners.Suite.SuiteClasses` annotation are used to run the suite test
	* Here is an example which uses TestJunit1 & TestJunit2 test classes
	* Even though if you keep any test case in Test suite class that test methods wont execute
```
import org.junit.Assert;
import org.junit.Test;
public class TestJunit1 {
 @Test
 public void test1() {
  System.out.println("inside test1()");
  Assert.assertEquals("Testing", "Testing"); }
}

public class TestJunit2 {
	 @Test
	 public void test2() {  
		System.out.println("inside test2()");  
		Assert.assertEquals("Testing", "Testing"); 
	}
}

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestJunit1.class, TestJunit2.class })
public class JunitTestSuite {
}
```
	* Run above test suite(JunitTestSuite)
```
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class App {
 public static void main(String[] args) {
  Result result = JUnitCore.runClasses(JunitTestSuite.class);
  for (Failure failure : result.getFailures()) {   
		System.out.println(failure.toString());  
	}
  System.out.println(result.wasSuccessful());
 }
}
```
* Parameterized Testing
* Assumptions
* Rules
* Theories
* Integration with popular build systems
* Test runners
* Junit classes
	* JUnit classes are important classes which is used in writing and testing Junits
-----
# Junit Annotations
* @Test
	* Define method as test case
* @Before
	* Several tests need similar objects created before they can run
	* Runs before each test case
* @After
	* If you allocate external resources in a Before method you need to release them after the test runs
	* Runs after each test case
* @BeforeClass
	* Runs before all test cases
	* Method should be `public static void`
* @AfterClass
	* Method should be `public static void`
	* Runs after all test cases
* @Ignore
	* Ignore specific test case which is annotated with this annotation
* @Test(expected=Exception.class)
	* Test case for exception case. Expected exception type is Exception.class
* @Test(timeout=100)
	* Time period within which test case has to execute otherwise test case will timeout
------
# Methods in Assert
* org.junitAssert class methods
* assertEquals
* assertTrue
* assertFalse
* assertNull
* assertNotNull
* assertSame
* assertNotSame
* fail
------
# Notes
* What is unit testing
	* Testing is the process of checking the functionality of the application whether it is working as per requirements and to ensure that at developer level, unit testing comes into picture. Unit testing is the testing of single entity (class or method). Unit testing is very essential to every software company to give a quality product to their customers
* What is Junit
	* JUnit is a unit testing framework for the Java Programming Language
* Advantages
	* JUnit is an open source framework which is used for writing & running tests.
	* Provides Annotation to identify the test methods. 
	* Provides Assertions for testing expected results. 
	* Provides Test runners for running tests. 
	* JUnit tests allow you to write code faster which increasing quality 
	* JUnit is elegantly simple. It is less complex & takes less time
	* JUnit tests can be run automatically and they check their own results and provide immediate feedback through a report of test results
	* JUnit tests can be organized into test suites containing test cases and even other test suites
	* Junit shows test progress in a bar that is green if test is going fine and it turns red when a test fails
* How many test cases for a piece of code
	* There must be at least two test cases for each requirement
		* one positive test
		* one negative test
		* If a requirement has sub-requirements, each sub-requirement must have at least two test cases as positive and negative
* Good Junit test will have 4 steps
	* setup
	* execute
	* verify
	* tear down
* Setup	
	* Establishment of data and fixture needed to execute the test
* Execution
	* Invocation of method under test
* Verification
	* Assertion of result returned by method under test
* Tear down
	* Clearing any data and fixtures created during setup
		* Ex: Clearing of data base records which inserted during testing
	* 2. release resources to avoid memory leaks
	* 3. deleting any files created during execution
* Testing exception thrown
```
// original method:
public class Exceptions{ 
    public String throwNullPointerException() {
       throw new NullPointerException("exception thrown from throwNullPointerException() method");
    }
}

// Test Method:
@Test(expected = NullPointerException.class)
	public void testThrowNullPointerException() throws Exception {
	new Exceptions().throwNullPointerException();
}
```