### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Hateoas
* What is Hateoas? - Hypermedia as the engine of application state
------
# Implementation options
## Custom format implementation
* Difficult to maintain
```
{
    "name": "a",
    "dept": "d1",
    "_links": {
        "all-employees": {
            "href": "http://localhost:9000/employees",
            "method": "GET"
        }
    }
}
```
## Standard implementation
* HAL (JSON Hypertext Application Language): simple format that gives consistent and easy way to hyperlink between resources in API
```
{
    "name": "a",
    "dept": "d1",
    "_links": {
        "all-employees": {
            "href": "http://localhost:9000/employees",
            "method": "GET"
        }
    }
}
```
* Refer - [Hateoas APIs](../../spring-boot-3/rest-api/README.md#hateoas-apis)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)