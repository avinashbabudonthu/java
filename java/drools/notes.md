## Drools Notes
* BLiP - Business Logic integration Platform
* Split into 2 parts
	* Authoring - Authoring process involves the creation of Rules files (.DRL files)
	* Runtime − It involves the creation of working memory and handling the activation

## Rule Engine
* Drools is declarative programmins
* drools rule engine work in loop
	* rule engine finds what rules to execute
	* pick one rule and fires it
	* firing the rule modifies data

## Rule design principles
* Rule should not depend on other rules
* Rule should depend only on data
* Rule atomicity
	* rule should be defined as simple as possible
	* complicated rules should be divided
* Data defines the rule to fire next
	* So order of rules execution may differ based on data
	* based on data rule may fire once, several times or not at all

## Structure of rule
```
when condition is true,
then action is executed
```

## Drools rule
```
when
	<condition>
then
	<actions>;
```

## Sample rule
```
rule "rule-name"
	attributes
	when
		left hand side of rule - written in MVEL or Java
	then
		right hand side of rule - written in Java
	end
```

## MVEL basics
* Equals
	* Classname(condition1, condition2, ..)
	* Classname(condition1 && condition2 && ..)
* Can use OR
	* Classname(condition1 || condition2 || ..)
* Value correction
	* "1234" == 1234
	
## MVEL Expressions
* `student.name` same as `student.getName()` in java
* student.?address.street. Below is Java
```
if(null != student.getAddress())
	return student.getAddress();
else
	return null;
```
* student.id == "12345"
```
"12345".equals(student.getId())
```
* student.course in ["java", "drools"]
```
java.utils.Arrays.asList("java", "drools").contains(student.getCourse())
```
* student == nil (or) student == null
```
student == null
```
* student.name = "jim jack" (or) student.name = 'jim jack'
```
student.setName("jim jack");
```

## Collections in MVEL
* Lists
	* names = ["jim", "jack", "jill"]
	* names[1] - returns jim
* Arrays
	* {"jim", "jack", "jill"}
	* Strings are arrays
		* name = "Jane"
		* name[0] return J
* Map
	* studentMap = ["1": "jim", "2": "jack"]
	* studentMap["1"] returns jim
	* studentMap.1 returns jim
	
## Stateless Sessions
* Usecases
	* Validations
	* Calculation
	* Routing and Filtering