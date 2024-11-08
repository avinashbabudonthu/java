# Serialization and De-serialization 

## Bullet points
* Store objects
* Store from runtime into a byte stream
* Restore from byte stream into runtime
* Save object to file system
* Save object to database. RDBMS store them in blob columns. OODBMS store directly
* Pass objects across memory addresses
* Pass objects over network
* Store object means, serialization stores entire object graph. Means it stores all objects that storing object points to
* De-serialization takes byte stream and rebuilds object graph
* Serialization means both
	* Serializing
	* De-serializing

## How
* Uses reflection
* Operates only on instance members
* If we want to apply for static, we can customize to do that

## Serialization Types
* Serializable interface
	* Implemented by any type that need to be serializable
	* This indicates that type supports serialization
	* Has no methods. This is marker interface
* ObjectOutputStream
	* class used to serialize
	* Take object graph and write it to stream
* ObjectInputStream
	* Take byte stream as input and create object graph

## Requirement for Serilization
* Implement Serilizable interface
* All members should be serializable
	* Primitive types are serializable by default
	* Other members other than primitives must implement Serializable interface

## If we serialize object with some parameters, changed class after serialization. How de-serialization will handle this?
* How changes to class definition (before and after serialization) effect serialization?
	* Serialze object with some fields
	* Change (add, edit, delete some fields) the class
	* Use changed class to de-serialize
	* We will get **InvalidClassException**
* How java identifies class format changed?
	* Whenever we serialize object JVM calculates serial version unique identifier. This is secure hash value that identifies the structure of class
	* When object is written to stream this serial version unique identifier will be included into stream content
	* If we change the fields of class, before de-serialization JVM calculates serial version unique identifier again. If these 2 values does not match then throw InvalidClassException
	* This InvalidClassException indicates that serialization version of class does not match with de-serialization version

## How we can maintain class compatibility and able to make changes to class?
* Java can calculate serial version unique identifier
* Factors effect to calculate serial verion unique identifier
	* Full type name
	* Implemented interfaces
	* Members
* Means content of type determines compatibility
* We can specify serial version as part of our type definition
	* By doing this we determine type compatibility
* We have to add field named **private static final long serialVersionUID**
* With serialVersionUID in our class, same serialVersionUID will be used while serialization and de-serialization
* JVM uses reflection to get serialVersionUID while serialization and de-serialization
* Addition fields will have default values as per their type

## Serialver utility
* Claculates serial version value same way Java runtime does
* Utility is found in jdk/bin folder
	* IDEs provide plug-in
* Uses class file to calculate serial version id
* Can pass class name on command line
	* Displays value on the console
* Can use **-show** option
	* This opens simple GUI
	
# Customizing Serialization
* Add **writeObject** method to our serialization type for customizing serializing process
* Add **readObject** method to our serialization type for customizing de-serializing process
* These two methods are called through reflection
* These methods normally marked as private
* writeObject
	* Return type is void
	* Throws **IOException**
	* Accepts **ObjectOutputStream**
		* Can use **defaultWriteObject** method from **ObjectOutputStream**
* readObject
	* Return type is void
	* Throws **IOException, ClassNotFoundException** 
		* ClassNotFoundException because when de-serializing we may encounter classes that are not there in class path
	* Access **ObjectInputStream**
		* use read methods
		* use readFields to get field name
			* Can access values by name of field
		* can use **defaultReadObject** method **ObjectInputStream**

# Exclude some fields from serialization
* Using **transient** key word
* Used for fields derived from another fields. To avoid unnecessay storage
* Restore value manually
	* By customizing de-serialization