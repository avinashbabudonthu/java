package com.sqs;

import java.util.List;

import org.junit.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

@SuppressWarnings("all")
public class SqsPractice {

	private static final String accessKey = "XXX";
	private static final String secretKey = "XXX";
	private static final String endPoint = "XXX";
	private static final String queueName = "MyQueue";

	/**
	 * Method to get Queue URL by passing queue name
	 */
	@Test
	public void getQueueURL() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		sqs.setEndpoint(endPoint);

		GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
		GetQueueUrlResult getQueueUrlResult = sqs.getQueueUrl(getQueueUrlRequest);
		String queueUrl = getQueueUrlResult.getQueueUrl();

		System.out.println("----- queue url ---------");
		System.out.println("queueUrl: " + queueUrl);
	}

	/**
	 * Method to get queue lists
	 */
	@Test
	public void listQueues() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		sqs.setEndpoint(endPoint);

		ListQueuesResult queues = sqs.listQueues();
		System.out.println("---- queues list-----");
		System.out.println(queues);
	}

	/**
	 * Method to send message to queue
	 */
	@Test
	public void sendMessageToQueue() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		String message = "Welcome to my queue";

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		sqs.setEndpoint(endPoint);

		GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
		GetQueueUrlResult getQueueUrlResult = sqs.getQueueUrl(getQueueUrlRequest);
		String queueURL = getQueueUrlResult.getQueueUrl();
		System.out.println("------- queue url----");
		System.out.println(queueURL);

		SendMessageRequest messageRequest = new SendMessageRequest(queueURL, message);
		System.out.println("---- send message----");
		SendMessageResult messageResult = sqs.sendMessage(messageRequest);
		System.out.println("-----message result-----");
		System.out.println(messageResult.toString());
	}

	/**
	 * Method to get messages from queue
	 */
	@Test
	public void getMessageFromQueue() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		sqs.setEndpoint(endPoint);

		GetQueueUrlRequest queueUrlRequest = new GetQueueUrlRequest(queueName);
		GetQueueUrlResult queueUrlResult = sqs.getQueueUrl(queueUrlRequest);
		String queueUrl = queueUrlResult.getQueueUrl();

		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
		ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMessageRequest);
		List<Message> messages = receiveMessageResult.getMessages();
		System.out.println("--- messages ----");
		System.out.println(messages);
	}

	/**
	 * Method to delete message from queue
	 */
	@Test
	public void deleteMessageFromQueue() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		sqs.setEndpoint(endPoint);

		GetQueueUrlRequest queueUrlRequest = new GetQueueUrlRequest(queueName);
		GetQueueUrlResult getQueueUrlResult = sqs.getQueueUrl(queueUrlRequest);
		String queueUrl = getQueueUrlResult.getQueueUrl();

		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
		ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMessageRequest);
		List<Message> messages = receiveMessageResult.getMessages();

		Message message = messages.get(0);
		String messageRecieptHandler = message.getReceiptHandle();
		System.out.println("message to be deleted: " + message.getBody() + ", handle: " + message.getReceiptHandle());

		DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest(queueUrl, messageRecieptHandler);
		sqs.deleteMessage(deleteMessageRequest);
	}
}