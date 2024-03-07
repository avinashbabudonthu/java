# Materials
* youtube - https://www.youtube.com/watch?v=2mVR_Qgx_RU
* https://www.tutorialspoint.com/dynamodb/index.htm
* udemy - AWS DynamoDB - The Complete Guide (Build 18+ Hands On Demos)
* youtube - https://www.youtube.com/watch?v=ovEq4L6tGfc
* youtube - https://www.youtube.com/watch?v=ijyeE-pXFk0
------
# Dynamo DB Notes
* NoSQL database from AWS. Supports both document and key-value store models
* Serverless Cloud NoSQL database
* Fast 
* Flexible 
* Cost Effective
* Highly Scalable
* Fault Tolerant
* Secure database service
* NOSQL helps in working with
	* High Volume
	* High Variety
	* High Velocity
* High availablity
* Suited for read heavy applications
* DACS - DynamoDB Accelerator Service. Caching service provided by AWS
------
# AWS CLI Commands
* Get tables list
```
aws dynamodb list-tables
```
------
# Terminology comparison with SQL
SQL                							| Dynamo DB
------------------ 							| ------------------
Table              							| Table
Rows			   							| Items
Columns			   							| Attributes
Primary Keys - Multicolumn and optional		| Primary keys - Mandatory, Minimum one and maximum two attributes
Indexes										| Local Secondary Indexes
Views										| Global Secondary Indexes
------
* JSON document store
* Mandatory attribute is called `partition_key`
* Optional attribute is called `sort_key` or `range_key`
* Primary key is mandatory in dynamo db
------
# Tables naming conventions
* prefix table names to create namespaces
* prefix.tablename (or) prefix_tablename
* Ex: test.users, test.tasks (or) test_users, test_tasks
* Not mandatory but good to follow
------
# Datatypes
* Scalar types
------
* DynamoDB spread across 3 regions globally
* Read consistency
	* Eventually consistent reads - all data written DDB replicates to 3 regions. This replication takes time (say 3 seconds), if application reads during this time then there is chance of dirty reads. In this case if your application is ok to have dirty read sometime then go for this
	* Strongly consistent reads - if application require to latest and accurate data. In this case all writes are committed prior to read taking place.

------
# Examples
* [Create table with local dynamo db setup](dynamo-db-practice/src/test/java/com/ab/DynamoDBPracticeTest.java)
------
# Dynamo DB local setup
* Download Dynamo DB latest jar from below links
	* Tarball − http://dynamodb-local.s3-website-us-west2.amazonaws.com/dynamodb_local_latest.tar.gz
	* Zip archive − http://dynamodb-local.s3-website-us-west2.amazonaws.com/dynamodb_local_latest.zip
* Extract zip
* Open cmd, navigate to above extracted folder
* Run following command
```
java -Djava.library.path=DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```