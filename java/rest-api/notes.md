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

# 3 Types of API consumers
* private
	* part of same organization that is building APIs
* public or external
	* outside provider organization
* partner
	* consumers trusted by API providers
* There is no difference in consuming these different API types. Difference is in how these APIs are managed

# Following should be taken while developing API
* API capabilities available to each type of consumers (public, private, partner)
* How to manag APIs
* API Security
	* private consumers
		* Basic Auth
		* Proprietary schemes
	* public and partner consumers
		* Key/Secret
		* OAuth
* Documentation made available to consumers of API
	* private and partner consumers
		* Internal Websites
		* PDFs
	* public consumers
		* Developer portal
* How access requests will be handled
	* private and partner consumers
		* Email
		* Internal ticketing process
	* public consumers
		* Request initiated from Developer portal
* How SLA (Service Level Agreement) will be managed - declares following features
	* Up time - 99.99%
	* Throughput - Maximum 20 call/second
	* Support - Email only
	* Define SLA Tiers
	* Runtime management - provider of API has to continuosly monitor the performance of API to ensure they are providing quality of service they have committed by way of the SLA Tiers
	
# API value chain
* Asset of value
	* Data and Integration
	* Service and Product
	* Social network data
* How provider of above assets will be benifitted in business perspective?
	* Direct Revenue
		* outside entities who access these assets pay for the use
	* Indirect Benefits like
		* Increase partner eco system
		* Competitive advantage
		* Agility
		* Social good
		* Brand recognition
* End consumers of Assets
	* Individual users
	* Enterprise users

# REST Architecture Constraints - 6 Design Rules
* Client - Server
	* use of client server design principles for implementing the REST APIs
* Uniform Interface
	* use of well defined contracts between client and server
* Statelessness
	* server should not manage the state of application
* Caching
	* server should use HTTP caching headers to cache responses to the request received from clients
* Layered
	* architecture should be layered. Each layer should be manageable independently
* Code on demand (Optional)
	* Server not only send data to the client in response to request, but it also can send code that client can execute

# Richardson Maturity Model - used to measure RESTfulness of an API architecture
* Level 0 - Also called `Swamp of POX(Plain Old XML)`
	* RPC calls means simple HTTP request-response calls
	* APIs are using XML as data format
* Level 1
	* Resources + URI
* Level 2
	* Resources + URI + Verbs (GET, POST, PUT, PATCH, DELETE)
* Level 3
	* Hypermedia control (HATEOAS)

# Client-Server architecture constraint
* Client - Requests for resources
* Server - Serves resources
* Decouple architecture
	* No impact of changes
	* Separation of concerns
	* Independent evolution

# Uniform Interface
* Client and server share common technical interface
* Interface: Defines contract between client and server
* 4 guiding principles to define contract
	* Individual resources are identified in the request(URI/URL)
		* http://api.acmecars.com/cars/12345
		* http://api.acmecars.com/cars/67890
	* Representation of resources
		* client receives representation of resource
	* Self descriptive messages - meta data like
		* Accept header
		* Content-Type
		* Http Status Code
		* Host
	* Hypermedia (HATEOAS)

# Statelessness
* Each request received by server treated as independ request

# Caching
* Use caching to achieve higher scalability and performance\
![picture Caching](imgs/caching.jpg)
* `Cache-Control` header will be used to specify cache policies
	* value will be multiple directive separated by comma. some cache directives has optional argument
	* Example: cache-control: public, max-age: 6400
		* No-store header - Response aren't allowed to be cached
		* Private - Cache only on use device
		* Public - resource may be cached in any cache
		* Max-Age - Time in seconds for cache expiry
* Expired - Set exact date/time in GMT when resource will get expired
* Last-Modified - Set date/time when resource last changed
* ETag - Unique identifier associated with response
	
# Layered
* Rest client
* Gateway
* Load balancer
* API provider
* Database\
![picture layered-1](imgs/layered-1.jpg)

# Code on demand - Server can extend the functionality of client by sending Code
* This is optional
* HATEOAS - Hypertext As The Engine Of Application State

# API Endpoint URL format
* http://domain/product/version/resource/{id}
* Some base http urls
	* Paypal - https://api.paypal.com
	* TicketMaster - https://app.ticketmaster.com
	* Uber - https://developer.uber.com
	* walmart - https://api.walmartlabs.com
	
# REST API Error Response
* Use following headers
	* Status-code: HTTP call status
	* Reason-Phrase: Information messages
	* x-custom-header: can use custom header to send error information. Generally error headers start with `x`
* Can also send status in response body
	* Define fixed format for all error responses
	* Contain application status code
	* Not suggested
* Error information in Header and Body
	* this is preferred approach

# How to design error response
* Informative and Actionable
	* By seeing error developer should understand the problem and should be able to take action
	* Provide links to API documentation
* Simple
* Consistent across all APIs
* Have own API status codes
* Error Template
```
text: erorrMessage
timestamp: time stamp when error occured
method: httpMethod
endPoint: end point information
errors: errorList
payload: request payload(optiona)
```
* Each error object in errorList
```
{
code: application-specific-error-code
text: message describing the error
hits: ["hints to developer on potential issue"]
info: link to API documentation
}
```

# Version specification options
* Custom Http header - x-api-version: 1.2
* Query parameter - /employees?version=1.2
* Path variable - /v2/employees

# version formats
* use date of release - 2021-09-15
* major.minor prefixed with v - v1.5
* number - v2

# Rest API cache control patterns
* What to cache and how long to cache? Based on
	* speed of data change
	* Time sensitivity of data
	* Security
* Cache control directives - `Cache-Control` header
	* allows API developer to control the caching behaviour of the API
	* we can decide - who can cache, how long data can cache, on what conditions data can cache

# Rest API Security
* Authentication
	* Basic authentication
	* Token based authentication
	* Key/Secret based authentication
* Authorization
	* OAuth 2.0
	
# API Documentation tools
* WADL
* api blueprint
* apiary
* RAML
* Swagger

# API Management
* what is API management?
	* Process of publishing, documenting and overseeing APIs in secure, scalable environment
* Following are scope activities to carry out as part of API management
	* Lifecycle management
	* Productivity enhancements as per business needs
	* Securing APIs
	* Traffic management
	* Analytics
	* Produtize
	* Monetization
* Some API management platforms
	* akana
	* APIGEE
	* 3scale
	* mulesoft
	* IBM API Connect
	* MASHERY
	* WSO2
* 2 models supported by API management platforms
	* Agent based
	* Proxy based
* Agent based

# Traffic Management
* API provider has to protect the backend
* protect the SLA to provide consitent response time to API
* 3 policies available on API management platforms for API traffic management
	* Quota policy
	* Rate limiting policy
	* Spike arrest policy

# API Analytics
* Why API Analytics
	* Service improvement - understand API consumer requirements
	* Catch errors
	* Understand threads/attacks
	* Business support
* Types of API Analytics
	* Perspective
		* Metrics
			* Performance
				* Response time
			* Throughput
			* Peaks/Valleys
			* API Errors
			* Backend Errors
			* Policy Errors
				* violation quota
				* rate limit
				* spike arrest
			* SLA
		* Visibility
			* Usage of APIs
				* Find most active client/users
				* Which APIs are mostly used
				* Based on region which APIs are most used
				* Device type - means from which device APIs are mostly used
			* Transactions
				* Specific to business
				* Logic to be build in proxy
				
# API Product & Monetization
* Treat APIs as product
* Monetization is about business+technology