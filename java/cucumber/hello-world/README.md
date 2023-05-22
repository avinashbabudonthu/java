# Cucumber Hello World

* Requirement
```
Introduction to Cucumber using Hello World Example
```

## Create project using maven
```
mvn archetype:generate -DgroupId=hello.world -DartifactId=hello-world -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```
## Examples
* [Hello World Calculator](#hello-world-calculator)
* [Pass Arguments From Feature to Step Definition](#pass-arguments-from-feature-to-step-definition)

### Hello World Calculator
* Create Core Java project using [maven](#create-project-using-maven)
* Create source folder - **src/test/resources**
* Create **features** folder in **src/test/resources**
* Create **[calculator.feature](src/test/resources/features/calculator.feature)** file
* Write **Gherkin** feature
* Write **[CalculatorStepDefinition.java](src/test/java/com/calculate/CalculatorStepDefinition.java)**
* **[CalculatorStepDefinition.java](src/test/java/com/calculate/CalculatorStepDefinition.java)** is mapped to **[calculator.feature](src/test/resources/features/calculator.feature)**
* Write **[CucumberTest.java](src/test/java/com/calculate/CucumberTest.java)**
* Declare below annotations at class level
```
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, snippets = SnippetType.CAMELCASE, features = "classpath:features")
```
* Right click on **[CucumberTest.java](src/test/java/com/calculate/CucumberTest.java)** - Run As - Junit Test
* Feature should be executed successfully

### Pass Arguments From Feature to Step Definition
* Create Core Java project using [maven](#create-project-using-maven)
* Create source folder - **src/test/resources**
* Create **features** folder in **src/test/resources**
* Create **[sum.feature](src/test/resources/features/sum.feature)** file
* Write **Gherkin** feature with variables
* Write **[SumStepDefinition.java](src/test/java/com/calculate/SumStepDefinition.java)**
* **[SumStepDefinition.java](src/test/java/com/calculate/SumStepDefinition.java)** is mapped to **[sum.feature](src/test/resources/features/sum.feature)**
* Write **[CucumberTest.java](src/test/java/com/calculate/CucumberTest.java)**
* Declare below annotations at class level
```
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, snippets = SnippetType.CAMELCASE, features = "classpath:features")
```
* Right click on **[CucumberTest.java](src/test/java/com/calculate/CucumberTest.java)** - Run As - Junit Test
* Feature should be executed successfully