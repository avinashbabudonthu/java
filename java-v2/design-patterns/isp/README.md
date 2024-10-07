### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Interface Segregation Principle
* Software modules (classes, methods) should not be forced to depend upon interfaces that they do not use
* It is not good that interface has large number of methods
* We should separate the methods accordingly
* Break interfaces in many smaller ones so they better satisfy the exact needs

# Example1
* Problem statement
```
Let's solve the following problem - we have a fat interface like this:

public interface Employee {
	// CEO + managers + workers
	public void salary();
	// managers
	public void hire();
	public void train();
	// CEO + managers
	public void addBonus();
	// CEO
	public void makeDecisions();	
	public void addStocks();
}
and of course we have 3 classes - Worker, Manager and CEO.
Let's split the fat interface into several interfaces and make sure the SOLID principle are not violated.
```
* IEmployee.java
```
public interface IEmployee {
    public void salary();
}
```
* IManager.java
```
public interface IManager extends IEmployee {
	public void hire();
	public void train();
	public void addBonus();
}
```
* ICEO.java
```
public interface ICEO extends IEmployee {
	public void makeDecisions();
	public void addStocks();
}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)