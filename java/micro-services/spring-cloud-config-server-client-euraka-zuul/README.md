# Requirement
* Create API producer
	* Customer service
	* Cart service
* Create Spring cloud config server
* Setup above Customer service as client to config server
* Create Zuul API gateway and implement logging 
	* All requests should go through API gateway and print log
	* Call API in Customer service via API gateway
	* Call API in Cart service via API gateway