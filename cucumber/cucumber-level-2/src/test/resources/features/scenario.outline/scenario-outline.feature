Feature: Cucumber scenario outline and background example
	All functionalities of calculator Add, Subtract, Multiply, Divisions
	
Background: 
	Given Calculate Operations 
		| add |
		
Scenario Outline: Calcualte 2 numbers 
	Given Two numbers 
	When Numbers are <Number1> and <Number2> 
	Then Addition is <Addition> 
	
	Examples: 
		| Number1 | Number2 | Addition |
		| 0 | 10 | 10 |
		| 20 | 10 | 30 |
		| 40 | 20 | 60 |