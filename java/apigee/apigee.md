# APIGEE

# Materials in study order
* Youtube - APIGEE Basics - https://www.youtube.com/playlist?list=PLIXjuPlujxxxe3iTmLtgfIBgpMo7iD7fk

# Notes
## APIGEE Features
* Create policies to adminster quotas
* Authorize users
* Charge for usage of APIs
* Enforce limit on usage
* Protect against security threats
* Make end points easily available for access using REST/SOAP and other protocols with minimal effort
* Create, Deploy, Undeploy API protocols using APIGEE Edge
* API Proxies primary mechanimsm for checking and enforcement of policies and has complex internal architecure like `ProxyEndPoints` and `TargetEndPoints`

## What is APIGEE
* API management platform helping to expose APIs in a secure way
* Help expose APIs in secure way
* APIGEE Edge
	* product allows us to `secure`, `deploy`, `monitor` and `scale` APIs
	* configure, manage APIs separately from backend services
	* Create API Proxies which act as Facade to backend services
* Can Secure, Monitize, Analytics on APIs
* Can use for dynamic routing
* Caching
* Rate Limits
* Performance Management like
	* Track active developers and apps
	* Response time and latency
	* Error rates
	* Revenue metrics
	* Traffic

## 	API Proxy
* Program that sits in front of API and proxies incoming user requests to the API and provides various value added features
* Secure API Calls
* Secure data

## API Product
* A collection of API resources (URLs) with quota (service plan) and protected by an API key

## API Package
* Group of API products monetize together as a bundle

## Types of end points
* ProxyEndPoint
	* Define how client apps can consume APIs
	* This is the end point that is directly accessible to users of API
	* Stages for pre-processing the request before sending to backend services like
		* Whether app is accessible over HTTP or HTTPS
		* What is security, quota etc
	* Post processing response before response returns to the application
* TargetEndPoint
	* Define how the API proxy interacts with backend services
	* when request comes, it first hits `ProxyEndPoint` then move on to the `TargetEndPoint`. Response move from `TargetEndPoint` to `ProxyEndPoint`
	* Responsible for forwarding request to the correct backend
	* Format the response in the correct format
* Both ProxyEndPoints, TargetEndPoints are made up of flows. They are called `PreFlows` or `PostFlows`

## Flows
* Sequential stages in API request processing path. Controls the flow of the request with logic, conditions and error handling
* Conditional flows executed based on conditions. Wont execute for all requests
* Types of flows
	* [PreFlows](#PreFlows)
	* [Conditional Flows](#Conditional-Flows)
	* [PostFlows](#PostFlows)
	* [PostClientFlows](#PostClientFlows)
![picture](images/ProxyEndPoints-TargetEndPoints.png)

## PreFlows
* Code that executes before anything else
* Can be part of ProxyEndPoint or TargetEndPoint
* Process that executes before ProxyEndPoint or TargetEndPoint is hit

## PostFlows
* Executed after conditional flows and PreFlows
* Good for
	* log data
	* notifications

## Conditional Flows
* Executed conditionally not for all APIs
* Executed after PreFlows and before PostFlows

## PostClientFlows
* Flow for logging messages after response returned to clients
* Only used in ProxyEndPoints

## Policy
* Module to control API behavior
* Apply certain process to our requests and responses
* Once we deploy API Proxy in APIGEE we create bunch of policies with our flows
* Some APIGEE common built in policies
	* Quotas
	* Key management
	* Authorization
	* Access Control
	* Response caching and transformation
* when we deploy API Proxy using APIGEE we can get number of features as well like
	* Protection against OWASP (Open Web Application Security Project)
		* Cross site Injection
		* Cross site scripting (XSS)
		* Cross site Request Forgery (CSRF)
		
## Organizations
* Top level container in APIGEE Edge
* Contains all API proxies and resources
* When we configure api proxy in APIGEE we will have organization as prefix. For example
```
http(s)://orgname-environment.apigee.net/proxy_base_path/...
```

## Environment
* Execution environment for API proxies
* An organization can contain multiple environments
* URL of API Proxy will also include environment after orgname
```
http(s)://orgname-environment.apigee.net/proxy_base_path/...
```

## Create APIGEE account
* Hit the url [https://login.apigee.com/sign__up](https://login.apigee.com/sign__up)
* Login or Follow the steps for SignUp

## Securing APIs using keys
* App developer must register client application with APIGEE
	* First setup developer account
	* This developer sets client application then developer will receive an API key
	* This API key must me included in every API request to proxy
* API Proxy will use this api key to authenticate
* This key in the control of APIGEE and can be revoked at any point of time
* We can configure keys which are valid for short time period
* API Proxies configured to use api keys verify the API key policy
	* key is valid
	* not revoked
	* matches the key for requested resource

## Create API Proxy
* Left Menu - click on Develop
* Click on `API Proxies`
* Click `+Proxy` button on top right
* Select proxy type. For example `Reverse Proxy`
	* Fill the details
	* Give URL in `Target` text box
* click `Next` button
* Select authorization. For example `Pass through` for public access
* Check other options available
* Click 'Next` button
* Select `secure for https`, `default for http`
* Click 'Next` button
* Select `test` to deploy in test environment
* Click 'Create` button

## Steps to access API with API Key
* Create API Proxy
	* Left Menu - click on Develop
	* Click on `API Proxies`
	* Click `+Proxy` button on top right
	* Select proxy type. For example `Reverse Proxy`
		* Fill the details
		* Give URL in `Target` text box
	* click `Next` button
	* Select `API Key` in 'Security: Authorization`
![picture](images/api-proxy-with-api-key.jpg)
	* Check other options available
	* Click 'Next` button
	* Select `secure for https`, `default for http`
	* Click 'Next` button
	* Select `test` to deploy in test environment
	* Click 'Create` button
* Now hit the API. For example `http://avinash4216-81780-eval-test.apigee.net/poa-info-2`. We will get following response
```
{"fault":{"faultstring":"Failed to resolve API Key variable request.queryparam.apikey","detail":{"errorcode":"steps.oauth.v2.FailedToResolveAPIKey"}}}
```
* Go to proxy and go to Develop tab. We can see policies - `Verify API Key`, `Remove Query Param apikey`
* Create API Product with above API Proxy
	* Click `Publish` in left menu
	* click `API Products`
	* click `+API Product` on top right
	* Access - `Public`
	* Select environment
	* Add a proxy
	* Add other details
	* click `Save` button on top right
* Create Developers
	* Click `Publish` in left menu
	* click 'Developers`
	* click `+Developer` on top right
	* Give details
	* click `Create` button
* Create Apps
	* Click `Publish` in left menu
	* click `Apps`
	* click `+App` button on top right
	* Select `Developer` check box. select developer in `Developer` text box
	* click `Add Product` button. Select the product we created above
	* click `Create` button on top right
	* Now it will create `apikey`, `secret`
* Now hit the API. For example `http://avinash4216-81780-eval-test.apigee.net/poa-info-2?apikey=fgLfPADfkj2f7ddKmxo5yX7UUpbwxxS9`. We wil get following response
```
{"app":{"name":"poa","description":"poa application","version":"1.1.0"},"java-vendor":"Oracle Corporation"}
```
* If we want to sent `apikey` as request header
	* Go to left menu - Develop/API Proxies
	* Go to Develop tab
	* select `Verify API Key` policy
		* Change `<APIKey ref="request.queryparam.apikey"/>` to `<APIKey ref="request.header.apikey"/>`