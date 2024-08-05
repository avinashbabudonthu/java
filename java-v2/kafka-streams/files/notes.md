### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# What is kafka streams?
* Library to process and transform data within kafka 
* Used for
	* Data transformations
	* Data Enrichment
	* Fraud Detection
	* Monitoring and Alerting
* Stand java application library
* No need to create separate kafka clusters
* Highly scalable, elastic and fault tolerant
* Exactly once capabilities - means process the record exactly once
* Processes one record at a time (no batching)
* Works for any application size\
![picture](../img/000001.jpg)
------
# Internal topics
* Running kafka streams creates internal intermediary topics
* Two types
	* Repartitioning topics: In case you start transforming the key of your stream then repartitioning will happen at some processor
	* Changelog topic: In case you perform aggregation then kafka streams will save compacted data in these topics
* Internal topics
	* Managed by kafka streams
	* Are used by kafka streams to save/restore state and re-partition data
	* Are prefixed by `application.id` parameter
	* Should never be deleted, altered and published to
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------