# Google pub sub consumer

* Create maven project using below command
```
mvn archetype:generate -DgroupId=com.infogain.gcp.poc -DartifactId=pub-sub-consumer -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

* Subscription Filters
```
attributes:mobileNumber
attributes:remark
```

* Filter prefixes
```
hasPrefix(attributes.mobileNumber, "900")

hasPrefix(attributes.remark, "901")
```

# References
* [https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes#0](https://codelabs.developers.google.com/codelabs/cloud-springboot-kubernetes#0)
* [https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f](https://medium.com/javarevisited/kubernetes-step-by-step-with-spring-boot-docker-gke-35e9481f6d5f)
* [https://cloud.google.com/pubsub/docs/filtering](https://cloud.google.com/pubsub/docs/filtering)
