### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Project setup
* Add required dependencies in [pom.xml](pom.xml)
------
# Basic feature
* Write feature file - [001-calculator.feature](src/test/resources/features/001-calculator.feature)
* Write step definition - [CalculatorStepDefinition001.java](src/test/java/com/java/step/defs/CalculatorStepDefinition001.java)
* Write test runner class - [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
* Add these annotation at class level to [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
```
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

Suite - to declare this as test runner suite
IncludeEngines - specifies the IDs of TestEngines to be included when running a test suite on the JUnit Platform
SelectPackages - Parent path where feature files are present
```
* Run [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
* [001-calculator.feature](src/test/resources/features/001-calculator.feature) should be executed successfully
------
# With variables
* Write feature file - [002-calculator.feature](src/test/resources/features/002-calculator.feature)
* See the variables declared in 
  * `Given` - 002 two numbers `<num1> and <num2>`
  * `Then` - 002 result is `<result>`
  * Passing values to `<num1> and <num2>` using `Examples`
* Write step definition - [CalculatorStepDefinition002.java](src/test/java/com/java/step/defs/CalculatorStepDefinition002.java)
* Getting variables declared in feature file to method
  * given method with `@Given("002 two numbers {long} and {long}")` annotation
  * then method with `@Then("002 result is {long}")` annotation
* Write test runner class - [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
* Add these annotation at class level to [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
```
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

Suite - to declare this as test runner suite
IncludeEngines - specifies the IDs of TestEngines to be included when running a test suite on the JUnit Platform
SelectPackages - Parent path where feature files are present
```
* Run [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
* [002-calculator.feature](src/test/resources/features/002-calculator.feature) should be executed successfully
------
# Tags
* [001-calculator.feature](src/test/resources/features/001-calculator.feature) has the tag `@calculator001`
  * `setup1`, `teardown1` methods in [CucumberTest.java](src/test/java/com/java/CucumberTest.java) execute before and after each test case of [001-calculator.feature](src/test/resources/features/001-calculator.feature)
  * Because same `@calculator001` tag is given on `setup1`, `teardown1` methods in [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
* [002-calculator.feature](src/test/resources/features/002-calculator.feature) has the tag `@calculator002`
  * `setup2`, `teardown2` methods in [CucumberTest.java](src/test/java/com/java/CucumberTest.java) execute before and after each test case of [002-calculator.feature](src/test/resources/features/002-calculator.feature)
  * Because same `@calculator002` tag is given on `setup2`, `teardown2` methods in [CucumberTest.java](src/test/java/com/java/CucumberTest.java)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)