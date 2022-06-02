# Google cloud spanner poller converter and pub sub publisher

* Create maven project using below command
```
mvn archetype:generate -DgroupId=com.infogain.gcp.poc -DartifactId=spanner-poller-converter-publisher -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Spanner DDL scripts
* pnrEntity table
```
CREATE TABLE pnr (
    pnr_id STRING(MAX),
    lastUpdateTimestamp TIMESTAMP NOT NULL OPTIONS (allow_commit_timestamp=true),
    mobileNumber STRING(MAX),
    remark STRING(MAX),
) PRIMARY KEY (pnr_id);
```

* poller commit timestamp
```
CREATE TABLE POLLER_COMMIT_TIMESTAMPS (
    last_commit_timestamp TIMESTAMP
) PRIMARY KEY (last_commit_timestamp);
```

# References
* [https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes#0](https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes#0)
* [https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f](https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f)
* [https://cloud.google.com/pubsub/docs/filtering](https://cloud.google.com/pubsub/docs/filtering)
