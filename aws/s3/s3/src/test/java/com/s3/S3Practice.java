package com.s3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Practice {

	private static final String MY_IAM_ACC_SECRET_KEY = "XXX";
	private static final String MY_IAM_ACC_ACCESS_KEY = "XXX";

	private static final String IAM_ACC_SECRET_KEY_2 = "XXX";
	private static final String IAM_ACC_ACCESS_KEY_2 = "XXX";

	@Test
	public void createBucket() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(IAM_ACC_ACCESS_KEY_2, IAM_ACC_SECRET_KEY_2);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTH_1)
				.build();

		if (s3Client.doesBucketExist("bucket-name-1")) {
			System.out.println("bucket exists");
		} else {
			System.out.println("bucket does not exist");
		}

		s3Client.createBucket("bucket-name-1");
	}

	@Test
	public void getListOfBuckets() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(MY_IAM_ACC_ACCESS_KEY, MY_IAM_ACC_SECRET_KEY);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
				.build();

		if (s3Client.doesBucketExist("bucket-name-1")) {
			System.out.println("bucket exists");
		} else {
			System.out.println("bucket does not exist");
		}

		List<Bucket> buckets = s3Client.listBuckets();
		buckets.stream().forEach(bucket -> System.out.println(bucket.getName()));
	}

	@Test
	public void deleteBuckets() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(IAM_ACC_ACCESS_KEY_2, IAM_ACC_SECRET_KEY_2);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTH_1)
				.build();

		if (s3Client.doesBucketExist("bucket-name-1")) {
			System.out.println("bucket exists");
		} else {
			System.out.println("bucket does not exist");
		}

		List<Bucket> buckets = s3Client.listBuckets();
		buckets.stream().forEach(bucket -> s3Client.deleteBucket(bucket.getName()));
	}

	@Test
	public void uploadObjectToBucket() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(MY_IAM_ACC_ACCESS_KEY, MY_IAM_ACC_SECRET_KEY);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
				.build();

		String bucketName = "bucket-name-1";
		String fileName = "E:\\s3\\abdul-kalam.jpg";
		if (s3Client.doesBucketExist(bucketName)) {
			System.out.println("bucket exists");
		} else {
			System.out.println("bucket does not exist");
		}

		s3Client.createBucket(bucketName);

		File file = new File(fileName);
		s3Client.putObject(bucketName, "abdul-kalam", file);
	}

	@Test
	public void downLoadObject() throws IOException {
		AWSCredentials awsCredentials = new BasicAWSCredentials(MY_IAM_ACC_ACCESS_KEY, MY_IAM_ACC_SECRET_KEY);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
				.build();

		String bucketName = "bucket-name-1";
		String objectKey = "abdul-kalam";

		S3Object s3Object = s3Client.getObject(bucketName, objectKey);
		S3ObjectInputStream inputStream = s3Object.getObjectContent();
		FileUtils.copyInputStreamToFile(inputStream, new File("E:\\s3\\abdul-kalam.jpg"));
	}

	@Test
	public void listObjects() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(MY_IAM_ACC_ACCESS_KEY, MY_IAM_ACC_SECRET_KEY);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
				.build();

		String bucketName = "bucket-name-1";
		ObjectListing objectListing = s3Client.listObjects(bucketName);
		for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
			System.out.println(os.getKey());
			System.out.println(os.getBucketName());
			System.out.println(os.getSize());
			System.out.println(os.getOwner());
			System.out.println("-----------------");
		}
	}

	@Test
	public void deleteObjects() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(MY_IAM_ACC_ACCESS_KEY, MY_IAM_ACC_SECRET_KEY);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
				.build();

		String bucketName = "bucket-name-1";
		ObjectListing objectListing = s3Client.listObjects(bucketName);
		for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
			s3Client.deleteObject(bucketName, os.getKey());
		}
	}
}