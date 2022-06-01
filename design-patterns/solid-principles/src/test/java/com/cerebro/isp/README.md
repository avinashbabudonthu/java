# Interface Segregation Principle Notes
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
... and of course we have 3 classes - Worker, Manager and CEO. 
Let's split the fat interface into several interfaces and make sure the SOLID principle are not violated.
```
* Solution
	* [ICEO](ICEO.java)
	* [IEmployee](IEmployee.java)
	* [IManager](IManager.java)