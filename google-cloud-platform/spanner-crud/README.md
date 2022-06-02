# Spanner CRUD APIs

# Create maven project using below command
```
mvn archetype:generate -DgroupId=com.infogain.gcp.poc -DartifactId=spanner-crud -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Spanner DDL scripts
* pnr table
```
CREATE TABLE pnr (
    pnr_id STRING(MAX),
    mobileNumber STRING(MAX),
    remark STRING(MAX),
    lastUpdateTimestamp TIMESTAMP NOT NULL OPTIONS (allow_commit_timestamp=true)
) PRIMARY KEY (pnr_id);
```

* pnr_out_box table
```
create table pnr_out_box(
    id string(max),
    pnr_id string(max),
    is_processed bool,
    retry_count int64,
    event_type string(max),
    processed_by string(max)
) primary key(id);
```

* poller commit timestamp - not needed
```
CREATE TABLE POLLER_COMMIT_TIMESTAMPS (
    last_commit_timestamp TIMESTAMP
) PRIMARY KEY (last_commit_timestamp);
```

# References
* [https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes#0](https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes#0)
* [https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f](https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f)
* [https://cloud.google.com/pubsub/docs/filtering](https://cloud.google.com/pubsub/docs/filtering)
