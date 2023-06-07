# Dynamo DB Notes
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
* DACS - DynamoDB Accelerator Service. Caching service provided by AWS
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