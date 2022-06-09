# Spring Integration Notes

# Main Components
* Endpoints
	* Producer (Sender)
	* Consumer (Receiver)
* Channels
	* Pipe

# Communication
* Produer send `Message` to consumer
* Message contains
	* Header
	* Content (payload)

# Types of Message Endpoints
* Adapters
	* connect our channel to some other system
* Filter
	* remove some messages from channel based on header, content etc
* Transformer
	* convert message content or structure
* Enricher
	* Add content to message header or payload
* Service activator
	* invoke service operations based on the arrival of message
* Gateway
	* connect your channels without SI coupling

# Message channels
* 2 types
	* Pollable channel
	* Subscribable channel
* There are many subtypes, all implement at least of one of the spring integration channel interfaces
* Message channels are represented by the `pipe` icon