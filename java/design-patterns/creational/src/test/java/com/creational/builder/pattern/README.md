# Builder Pattern
# Why builder pattern
* Having so many parameters in constructor is called `telescoping constructor`. We should avoid `telescoping constructor` because if we need to add 1 more parameter we need to add 1 more constructor so this approach is not scalable.

# Packing classes
* Create an interface [Packing](Packing.java)
* Create class [Wrapper](Wrapper.java) implements [Packing](Packing.java)
* Create a class [Bottle](Bottle.java) implements [Packing](Packing.java)

# Item classes
* Create interface [Item](Item.java)

# Burger classes
* Create abstract class [Burger](Burger.java) implements [Item](Item.java)
	* Override `packing` method from [Item](Item.java)
* Create a class [ChickenBurger](ChickenBurger) extends [Burger](Burger.java)
	* Overrider `name`, `price` methods from [Item](Item.java)
* Create class [VegBurger](VegBurger.java) extends [Burger](Burger.java)
	* Overrider `name`, `price` methods from [Item](Item.java)

# Drink classes
* Create abstract class [Drink](Drink.java) implements [Item](Item.java)
	* Override `packing` method from [Item](Item.java)
* Create class [Coke](Coke.java) implements [Drink](Drink.java)
	* Overrider `name`, `price` methods from [Item](Item.java)
* Create class [Pepsi](Pepsi.java) extends [Drink](Drink.java)
	* Overrider `name`, `price` methods from [Item](Item.java)

# Meal classes
* Create class [Meal](Meal.java)
* Create class [MealBuilder](MealBuilder.java). Write 2 methods
	* prepareVegMeal
	* prepareNonVegMeal

# Test class
* Create [BuilderPattern](BuilderPattern.java)
* Create [MealBuilder](MealBuilder.java) object
* Call methods on [MealBuilder](MealBuilder.java) object