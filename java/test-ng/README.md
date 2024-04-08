# Materials
* https://testng.org/
* https://www.javatpoint.com/testng-tutorial
------
# Examples
* [TestNG01](test-ng-01)
------
# TestNG Annotations
* @BeforeSuite
	* The @BeforeSuite annotated method will run before the execution of all the test methods in the suite
* @AfterSuite
	* The @AfterSuite annotated method will run after the execution of all the test methods in the suite
* @BeforeGroups
	* The @BeforeGroups annotated method run only once for a group before the execution of all test cases belonging to that group
* @AfterGroups
	* The @AfterGroups annotated method run only once for a group after the execution of all test cases belonging to that gro
* @BeforeClass
	* The @BeforeClass annotated method will be executed before the first method of the current class is invoked
* @AfterClass
	* The @AfterClass annotated method will be invoked after the execution of all the test methods of the current class
* @BeforeTest
	* The @BeforeTest annotated method will be executed before the execution of all the test methods of available classes belonging to that folder
* @AfterTest
	* The @AfterTest annotated method will be executed after the execution of all the test methods of available classes belonging to that folder
* @BeforeMethod
	* The @BeforeMethod annotated method will be executed before each test method will run
* @AfterMethod
	* The @AfterMethod annotated method will run after the execution of each test method

# Hierarchy of the TestNG Annotations
* @BeforeSuite
* @BeforeTest
* @BeforeClass
* @BeforeMethod
* @Test
* @AfterMethod
* @AfterClass
* @AfterTest
* @AfterSuite

# Benefits of using TestNG Annotations:
* TestNG Annotations made the life of testers very easy. Based on your requirements, you can access the test methods, i.e., it has no predefined pattern or format.
* You can pass the additional parameters to TestNG annotations.
* In the case of TestNG annotations, you do not need to extend any test classes.
* TestNG Annotations are strongly typed, i.e., errors are detected at the compile time
------
