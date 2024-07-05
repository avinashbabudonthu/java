### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Splunk data pipeline
* Input: Forward data, upload data, network data, scripts
* Parsing: Examines the data, adds metadata
* Indexing: Data divided into events. Writes the data to disk in `buckets`
* Searching: User interaction with data
* Mem-tip: IPIS
------
# Splunk Platform
* Splunk Enterprise
* Splunk cloud platform

## Splunk Enterprise
* Deployed on own data centers

## Splunk cloud platform
* Deployed and maintained by Splunk
------
# Splunk data
## Splunk adds default fields to all events
* _time: in unix time format.  If data does not have time information then Splunk uses the information when data was inedxed
* index
* host: Hostname or IP address of source system.
* source: Name of the file, input, event from which event originates
* sourcetype: format of the data. 
------
# Search in Splunk
* SPL - Search Processing Language


------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)