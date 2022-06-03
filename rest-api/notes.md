## What is webservice?
* Service delivered over the web
* Software system designed to support interoperable machine to machine interaction over a network
* Designed for application to application interaction
* Interoperable - Not platform dependent
* Shoud allow communication over network

## How applications exchange data?
* Http Request and Response

## How webservices are platform independent?
* Exchange data in platform independent way with following formats
	* XML
	* JSON
	
## How calling application knew repsonse format?
* With Service Definition
	* Request and Response format
	* Request Structure
	* Response Structure
	* Endpoint
	
## Webservices key terminology
* Request - Input to webservice
* Response - Output of webservice
* Message Exchange Format - Format of the request and response like `XML`, `JSON`
* Service Provider - Server
* Service Consumer - Client
* Service Definition - Contract between service provider and consumer
* Transport - How service is called
	* Http
	* MQ - `Messaging Queues`
	
## Kinds of webservices
* SOAP
	* Simple Object Access Protocol
	* XML is request and response exchange format
	* Has - Envolop. Contains
		* Header
			* Authentication
			* Authorization
			* Signature
		* Body
			* Content of the request
	* Service Definition
		* WSDL - Web Service Definition Language
			* Endpoint
			* Operations
			* Request and Response structure
* REST - Representational State Transfer
	* Communication over Http
	* Http Methods
		* GET - Select data
		* POST - Save data
		* PUT - Full update
		* PATCH - Partial update
		* DELETE - Delete data
	* Resource
		* Anything we want to expose to outside world
		* Resource has an URI
		* Can have different representations
			* XML
			* JSON
	* Tools for documentation
		* Swagger
		
## REST API guidelines and best practices
* Find all employees
	* Method - `GET`
	* URI - `/employees`
	* Return body with status `200 OK` if data found
	* Return status `204 No Content` if no data found
	
* Find employee by id
	* Method - `GET`
	* URI - `/employees/{id}`
	
* Save employee
	* Method - `POST`
	* URI - '/employees`
	* Body - `Employee Json`
	* Return URI to find newly created object like - `/employees/{id}`
	* Return status code `201 - Created`
		* Spring Boot - `org.springframework.http.ResponseEntity.created(uri).body(student);`

* Full update employee
	* Method - `PUT`
	* URI - `/employees`
	* Body - `Employee Json`
	
* Partial update employee
	* Method - `PATCH`
	* URI - `/employees`
	* Body - `Employee Json`
	
* Delete employee by id
	* Method - `DELETE`
	* URI - `/employees/{id}`*
	
* Always return proper status code
* Implement global exception handling
* Convert entities to model objects and return as API response
* Apply pagination to find/search APIs
* Add validations 
	* Return proper error code and error messages
* Name API from consumre perspective. Is it self explanatory
* Have documentation that consumers easily understand
	* Swagger
* No secure info in URI like
	* username
	* ssn
* Always use plurals for URI like
	* /students
	* /users
	* /employees

## Richardson Maturity Model
### Level 0
* Include verbs in API like
	* http://localhost:9000/saveStudent
	* http://localhost:9000/getStudent/100
	* http://localhost:9000/getAllStudents
	
### Level 1 - Exposing resources with proper URI but Improper use of HTTP Methods
* http://localhost:9000/students
* http://localhost:9000/students/100

### Level 2 - Exposing resources with proper URI + Proper use of HTTP Methods
* Exposing resources with proper URI like
	* POST - http://localhost:9000/students
	* GET - http://localhost:9000/students/100
	* DELETE - http://localhost:9000/students

### Level 3
* Exposing resources with proper URI + Proper use of HTTP Methods + HATEOAS

## Versioning REST APIs
* Versioning using URI
	* /v1/students
	* /v2/students
* Using Request Param
```
@GetMapping(value = "/students/param", params = "version=1", produces = MediaType.APPLICATION_JSON_VALUE)

@GetMapping(value = "/students/param", params = "version=2", produces = MediaType.APPLICATION_JSON_VALUE)
```
* Header versioning
```
@GetMapping(value = "/students/header", headers = "version=1", produces = MediaType.APPLICATION_JSON_VALUE)
@GetMapping(value = "/students/header", headers = "version=2", produces = MediaType.APPLICATION_JSON_VALUE)
```

* Content Type versioning
```
@GetMapping(value = "/students/produces", produces = "application/my.app-v1+json")
@GetMapping(value = "/students/produces", produces = "application/my.app-v2+json")
```