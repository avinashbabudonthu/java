# Types of NoSQL Databases
* Columnar database
* Key-Value store
* Graph database
* Document database
------
# Columnar database
* Column oriented
* Optimized for reading and writing columns of data rather than rows of data
* Good for things like Data warehouse and analytics
* Reduces disk io requirements
* Examples
* [Apache cassandra](../README.md#cassandra)
* Apache HBase
* Amazon Redshift
------
# Key-Value store
* Data is stored in key value pairs
* Optimized for read heavy applications like social networking, gaming, media sharing applications
* Suitable for compute heavy applications like recommendation engines
* These databases use in memory caching to improve application performance
* Examples
* [Redis](../README.md#redis)
* Couchbase server
* Memcached
* [AWS DynamoDB](../README.md#aws)
------
# Graph database
* we have nodes which relationship with other nodes called edgs
* suitable for social networks where everything is related
* Examples
* Neo4J
* OrientDB
* AWS Neptune
------
# Document database
* Used to store semi structured data as documents typically as JSON or XML
* Schema less
* Examples
* [Apache cassandra](../README.md#cassandra)
* [Couchbase](../README.md#couch-base)
* [MongoDB](../README.md#mongo-DB)
* [AWS DynamoDB](../README.md#aws)