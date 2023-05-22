# Drools Hello World

## Requirement
* Validate Students
* Students with age greater than 21 are not allowed for Engineering
* Student age less than 15 are not allowed for Engineering

## Maven command
```
mvn archetype:generate -DgroupId=hello.world -DartifactId=hello-world -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Dependencies
* Refer [pom.xml](pom.xml)

## Examples
### Students Rules
* [StudentRules.java](src/main/java/hello/world/StudentRules.java)
* [student-rules.drl](src/main/resources/student/rules/student-rules.drl)
* [kmodule.xml](src/main/resources/META-INF/kmodule.xml)
	* ksession name - `StudentRules`
* Model class - [Student.java](src/main/java/hello/world/model/Student.java)

### Set global variable
* Model class - [Student.java](src/main/java/hello/world/model/Student.java)
* class to initiate rule execution - [StudentRules.java](src/main/java/hello/world/StudentRules.java)
	* Refer methods:
		* isStudentPresent
		* ageGreaterThan21
		* ageLessThan15
		* isCorrectAge
	* Create student list on which rules has to execute
	* Create `KieContainer`, `KieSession` objects
	* To `KieSession` give `ksession` name given in [kmodule.xml](src/main/resources/META-INF/kmodule.xml) file
	* Create `StudentAgeValidation` object and set at `global` so that can be access in drl file for multiple rules
		* `StudentAgeValidation` object we are using in [rule1.drl](src/main/resources/rules/rule1.drl) as `global StudentAgeValidation studentAgeValidation;`
		* `StudentAgeValidation` used in [rule1.drl](src/main/resources/rules/rule1.drl) to call `printMessage` method
		
### Employee Rules
* [EmployeeRules.java](src/main/java/hello/world/EmployeeRules.java)
* [employee-adress-rules.drl](src/main/resources/employee/rules/employee-adress-rules.drl)
* [kmodule.xml](src/main/resources/META-INF/kmodule.xml)
	* ksession name - `EmployeeRules`