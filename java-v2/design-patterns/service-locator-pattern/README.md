### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# What is service locator pattern
* The purpose of the Service Locator pattern is to return the service instances on demand. This is useful for decoupling service consumers from concrete classes.
* An implementation will consist of the following components:
	* Client: the client object is a service consumer. It's responsible for invoking the request from the service locator
	* Service Locator: is a communication entry point for returning the services from the cache
	* Cache: an object for storing service references to reuse them later
	* Initializer: creates and registers references to services in the cache
	* Service: the Service component represents the original services or their implementation
* The original service object is looked up by the locator and returned on demand.
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)