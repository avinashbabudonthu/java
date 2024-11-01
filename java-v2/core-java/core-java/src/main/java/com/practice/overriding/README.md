# Overriding
* Define 2 methods in [Parent1](Parent1.java)
  * method1
  * method2
* Define [Child1](Child1.java) extends [Parent1](Parent1.java)
  * Override method2
* Call method2 from method1
* If we create [Parent1](Parent1.java) object and call `method1` then
  * method1 from [Parent1](Parent1.java) is called
  * method2 from [Parent1](Parent1.java) is called
* If we create [Child1](Child1.java) object and call `method1` then
    * method1 from [Parent1](Parent1.java) is called
    * method2 from [Child1](Child1.java) is called
* Refer [Main](Main.java)