# AWS Difference between SQS and SNS
## Introduction
* Do you know about the AWS messaging services?
* Well, If you want to make communication and information exchange between different components of a distributed system easy, then AWS offers a range of messaging services. These messaging services play a crucial role in building scalable, decoupled, and reliable architectures on the AWS cloud platform.

## What are SQS and SNS?
* In AWS, SQS stands for Amazon Simple Queue Service, and SNS stands for Amazon Simple Notification Service. 

## Amazon Simple Queue Services (SQS)
* Amazon SQS is a fully managed message queuing service that enables decoupling and asynchronous communication between different components or systems. It provides a reliable and scalable way to transmit messages between distributed software components. With SQS, you can send, store, and receive messages between independent systems without the need for direct connections or tight coupling.

## Amazon Simple Notification Service (SNS)
* Amazon SNS is a publish-subscribe messaging service that facilitates the sending of messages to multiple subscribers or endpoints. It acts as a central messaging hub that allows publishers to send messages to topics, and then subscribers receive those messages. SNS supports multiple protocols for message delivery, including email, SMS, HTTP, Lambda functions, and more.

## Although both services are part of AWS's messaging and queuing offerings, they serve different purposes. Let’s have a look at how SQS and SNS are different from each other.

## Difference between SQS and SNS
### Message Pattern
* SQS- Queue (Similar to JMS, MSMQ) - SQS follows a message queuing model, where messages are sent by producers and stored in a queue. Consumers retrieve and process these messages from the queue independently, enabling asynchronous and decoupled communication between components.
* SNS- Topic- Subscriber (Pub/Sub System) - SNS follows a publish-subscribe model, where messages (or notifications) are published to topics by producers. Subscribers (or endpoints) can subscribe to these topics and receive messages instantly when they are sent.

### Message Consumption
* SQS- Pull Mechanism - Messages are not directly delivered to consumers but are pulled from the queue when they are ready to be processed.
* SNS- Push Mechanism - SNS acts as a central messaging hub, broadcasting messages to multiple subscribers simultaneously.

### Message Delivery 
* SQS- Messages in SQS are stored persistently in a queue until they are explicitly retrieved and deleted by consumers. Each message is processed by only one consumer, ensuring that messages are not delivered to multiple recipients.
* SNS- Messages in SNS are delivered instantly to all subscribed endpoints or subscribers. When a message is published to a topic, all subscribers that have registered for that topic will receive a copy of the message. This allows for fanout messaging, where a single message is sent to multiple recipients simultaneously.

### Consumer Configuration
* SQS- Consumers (referred to as workers or receivers) poll the queue to retrieve messages at their own pace. They can retrieve and process messages independently, allowing for distributed and scalable systems. SQS supports features like message visibility timeout and long polling, which provide flexibility in handling message retrieval and processing.
* SNS- Subscribers or endpoints in SNS do not have to actively retrieve messages. Messages are delivered directly to the subscribed endpoints using various delivery protocols (such as HTTP, email, SMS, and Lambda functions). Subscribers receive messages instantly without the need for polling.

## When to apply SQS and SNS?
### Use Cases of SQS
* Workload decoupling- It is useful in scenarios where different components need to communicate asynchronously without direct dependencies.
* Task queues- It ensures that tasks are processed in a reliable and scalable manner, even when the workload varies.
* Event-driven processing- It allows for scalable event-driven architectures and ensures that events are not lost, even during high traffic or system failures.
Scaling and fault tolerance- It provides fault tolerance by storing messages redundantly, reducing the risk of message loss.
* Microservices communication- Each microservice can send and receive messages through queues, enabling loosely coupled and scalable architectures.

### Use Cases of SNS
* Real-time notifications- It enables instant delivery of messages to multiple subscribers, ensuring timely updates or alerts.
* Mobile push notifications- It allows developers to reach their app users with important updates or personalized content.
* Email and SMS messaging- It is useful for sending transactional emails, marketing campaigns, or one-time passwords (OTPs) via SMS.
* Event-driven architectures- It allows different components or services to subscribe to topics and receive relevant messages, enabling flexible and loosely coupled systems.
* Fanout messaging- This feature is valuable in scenarios where a message needs to be sent to a large number of recipients, such as broadcasting news updates or distributing system-wide notifications.
* Application integration- It simplifies the integration of different services and enables building event-driven workflows.

## Conclusion
* Well, SQS and SNS are quite different from each other as SQS is mainly used to decouple applications and SNS distributes several copies of a message to several subscribers