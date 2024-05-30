# Use cases
* Backup and Storage
* Disaster Recovery
* Archive
* Hybrid cloud Storage
* Application hosting
* Media hosting
* Data lakes& Big data analytics
* Software delivery
* Static website
------
# buckets
* Allows store objects (files) in `buckets`
* Buckets must have global unique name (across all regions all accounts)
* Buckets are defined at region level
* S3 looks like global service but buckets are created at region level
* Naming convention
	* No uppercase
	* No underscore
	* 3 to 63 characters long
	* Not an IP
	* Must start with lowercase letter or number
	* Must not start with prefix `xn--`
	* Must not end with suffix `-s3alias`
------
# objects
![picture](imgs/01-objects.jpg)
* Object values are content of the body
	* Max object size is 5 TB (5000 GB)
	* If uploading more than 5GB file then must use `multi-part upload`
* Metadata (list of text key / value pairs - system or user metadata)
* Tags (Unicode key / value pair - up to 10) - useful for security / lifecycle
* Version ID (if versioning is enabled)
------
# S3 Simple Storage Service
* Storage on the internet
* HTTP access
* Store and retrieve any amount of data, any time, from any where on the web
* Highly scalable, reliable, fast and durable
* Data will be stored in buckets
* 100 bucket limit per account
* Can store unlimited number of objects in a bucket
* Size of object can be upto 5 TB
* Highly scalable, reliable, fast
* Stores data as `Object` with in bucket
* we can control access to bucket and it's objects
* Have `globally unique bucket names` regardless of AWS region in which they were created
* Object key - unique identifier for an object in bucket - http://doc.s3.amazonaws.com/2022-01-17/myfile.html
	* `doc` - bucket name
	* `2022-01-17/myfile.html` - Object key
------
# Security
* can control access to bucket and objects in the bucket with
	* ACL - Access Control List
	* Bucket policies
	* IAM policies
* Can upload or download data to S3 via SSL encrypted endpoints
* Can encrypt data using AWS SDKs\
![picture](imgs/01-security.jpg)
------
# S3 Bucket policies
![picture](imgs/01-policies.jpg)
------
# S3 storage classes
* Amazon S3 Standard - Default
	* Frequently used data
* Amazon S3 Standard - Infrequent Access (IA)
	* Long lived less frequently accessed data
	* Used for backups, older data, accessed less but still required high performance
* Amazon S3 One Zone - Infrequent Access
* Amazon S3 Glacier Instant retrieval
* Amazon S3 Glacier Flexible retrieval
* Amazon S3 Glacier Deep Archive
* Glacier
	* Archived data
	* cheaper
	* Not available for real time access
	* Must restore objects before access them
	* when request an object from Glacier, you need to create job that take anywhere between 3-5 hours for the job to complete and object to be available for download
	* Less than $0.01 GB / month (depending on region)\
![picture](imgs/01-amazon-s3-glacier.jpg)
* Amazon S3 Intelligent Tiering\
![picture](imgs/01-amazon-s3-intelligent-tiering.jpg)
* Storage Classes Comparison\
![picture](imgs/01-storage-classes-comparison.jpg)
* Moving between storage classes\
![picture](imgs/01-moving-between-storage-classes.jpg)
* Life cycle rules\
![picture](imgs/01-life-cycle-rules.jpg)
------
# Pricing
* pay for only what you use
* no minimum fee
* price based on location of amazon s3 bucket
* estimate monthly bill using `AWS Simple Monthly Calculator`
* Pricing is available as
	* Storage pricing
	* Request pricing
	* Data transfer pricing: data transferred out of Amazon S3
------
# Versioning
* protect for accidental overwrites and deletes with no perfomance penalty
* Generates new version with every upload
* Allows easily retrieval of deleted objects or roll back to previous versions
* 3 states of Amazon S3 bucket
	* Un-versioned (default)
	* Versioning enabled
	* Versioning suspended\
![picture](imgs/01-versioning.jpg)
------
# Replication
* CRR - Cross Region Replication
* SRR - Same Region Replication\
![picture](imgs/01-replication.jpg)
![picture](imgs/02-replication.jpg)
------
# Requester pays
![picture](imgs/01-requester-pays.jpg)
------
# Event Notifications
![picture](imgs/01-event-notifications.jpg)
![picture](imgs/02-event-notifications.jpg)
![picture](imgs/03-event-notifications.jpg)
------
# performance
![picture](imgs/01-performance.jpg)
![picture](imgs/02-performance.jpg)
![picture](imgs/03-performance.jpg)
------
# S3 select
![picture](imgs/01-s3-select.jpg)
------
# Batch operations
![picture](imgs/01-batch-operations.jpg)
------
# Object encryption
![picture](imgs/01-enryption.jpg)
![picture](imgs/02-enryption.jpg)
![picture](imgs/03-enryption.jpg)
![picture](imgs/04-enryption.jpg)
![picture](imgs/05-enryption.jpg)
![picture](imgs/06-enryption.jpg)
![picture](imgs/07-enryption.jpg)
![picture](imgs/08-enryption.jpg)
![picture](imgs/09-enryption.jpg)
------
# S3 CORS
![picture](imgs/01-cors.jpg)
![picture](imgs/02-cors.jpg)
![picture](imgs/03-cors.jpg)
* S3 CORS settings script
```
[
  {
    "AllowedHeaders": [
      "Authorization"
    ],
    "AllowedMethods": [
      "GET"
    ],
    "AllowedOrigins": [
      "url of first bucket with http://...without slash at the end"
    ],
    "ExposeHeaders": [],
    "MaxAgeSeconds": 3000
  }
]
```
------
# S3 Access Logs
![picture](imgs/01-access-logs.jpg)
![picture](imgs/02-access-logs.jpg)
------
# Access points
![picture](imgs/01-access-points.jpg)
------
# S3 Object Lambda
![picture](imgs/01-object-lambda.jpg)