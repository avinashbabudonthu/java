### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Difference between model object and entity object
* The advantage of using the same objects for entities and MVC model classes is that it is simpler, in that you need fewer classes to get the job done.
There are two main disadvantages I see. First, entity classes are transactional, since they are bound to database read and write operations. If model classes are also entity classes, this means the MVC layer of the application has to deal with transactions. In Spring this is done with the OpenSessionInViewFilter, which holds a transaction open for the duration of the MVC operation. This approach can be made to work, but it is also considered an anti-pattern (i.e. a bad idea) by many, including myself.
Second, as applications become more complex, differences start to emerge between persistence considerations and presentation considerations. If you only have one class shared between the layers it starts to get pulled in two directions and can end up kind of messy and ugly.
* Persistent entities should not be used as arguments of "@RequestMapping" methods
	* Vulnerability
	* Critical
* On one side, Spring MVC automatically bind request parameters to beans declared as arguments of methods annotated with @RequestMapping. Because of this automatic binding feature, it's possible to feed some unexpected fields on the arguments of the @RequestMapping annotated methods.
* On the other end, persistent objects (@Entity or @Document) are linked to the underlying database and updated automatically by a persistence framework, such as Hibernate, JPA or Spring Data MongoDB.
* These two facts combined together can lead to malicious attack: if a persistent object is used as an argument of a method annotated with @RequestMapping, it's possible from a specially crafted user input, to change the content of unexpected fields into the database.
* For this reason, using @Entity or @Document objects as arguments of methods annotated with @RequestMapping should be avoided.
* In addition to @RequestMapping, this rule also considers the annotations introduced in Spring Framework 4.3: @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping.

* Noncompliant Code Example
```
import javax.persistence.Entity;

@Entity
public class Wish {
  Long productId;
  Long quantity;
  Client client;
}

@Entity
public class Client {
  String clientId;
  String name;
  String password;
}

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WishListController {

  @PostMapping(path = "/saveForLater")
  public String saveForLater(Wish wish) {
    session.save(wish);
  }

  @RequestMapping(path = "/saveForLater", method = RequestMethod.POST)
  public String saveForLater(Wish wish) {
    session.save(wish);
  }
}
```
* Compliant Solution
```
public class WishDTO {
  Long productId;
  Long quantity;
  Long clientId;
}

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseOrderController {

  @PostMapping(path = "/saveForLater")
  public String saveForLater(WishDTO wish) {
    Wish persistentWish = new Wish();
    // do the mapping between "wish" and "persistentWish"
    [...]
    session.save(persistentWish);
  }

  @RequestMapping(path = "/saveForLater", method = RequestMethod.POST)
  public String saveForLater(WishDTO wish) {
    Wish persistentWish = new Wish();
    // do the mapping between "wish" and "persistentWish"
    [...]
    session.save(persistentWish);
  }
}
```
* Exceptions
	* No issue is reported when the parameter is annotated with @PathVariable from Spring Framework, since the lookup will be done via id, the object cannot be forged on client side.
* References
	* OWASP Top 10 2017 Category A5 - Broken Access Control - https://www.owasp.org/index.php/Top_10-2017_A5-Broken_Access_Control
	* MITRE, CWE-915 - Improperly Controlled Modification of Dynamically-Determined Object Attributes - http://cwe.mitre.org/data/definitions/915.html
	* Two Security Vulnerabilities in the Spring Framework’s MVC by Ryan Berg and Dinis Cruz - https://o2platform.files.wordpress.com/2011/07/ounce_springframework_vulnerabilities.pdf
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)