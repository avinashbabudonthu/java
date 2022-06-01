# Liskov Substitution Principle Notes
* It would be great if the new derived class would work as well without replacing functionality of the class
* Otherwise the new classes can produce undesired effects when they are used in existing program modules
* Objects of superclass shall be replaceable with objects of the sub classes without breaking the application
* Design patterns used to implement lsp
	* Strategy pattern
	* Template pattern

# Example
* [Fuel](Fuel.java) interface
* [Vehicle](Vehicle.java) abstract class
* [PetrolCar](PetrolCar.java) class extends [Vehicle](Vehicle.java)
* [ElectricCar](ElectricCar) class extends [Vehicle](Vehicle.java)
* [App](App.java)