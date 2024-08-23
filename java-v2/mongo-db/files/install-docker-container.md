### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Install with docker container
* Pull mongodb container
```
latest:
docker pull mongodb/mongodb-community-server:latest

specific version:
docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:5.0-ubuntu2004
```
* Run the container
```
docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:latest
```
* Check running container
```
docker ps -a
```
* Connect with [Mongosh](install-mongosh.md)
* When `mongosh` started by default it will connect to port `27017`. Or else run `mongosh.exe` with port number using below command
```
mongosh --port 27017
```
* Validate the deployment
```
db.runCommand(
   {
      hello: 1
   }
)
```
* result of this command returns a document describing your mongod deployment
```
{
  isWritablePrimary: true,
  topologyVersion: {
    processId: ObjectId('66c866ba230341005365f'),
    counter: Long('0')
  },
  maxBsonObjectSize: 16777216,
  maxMessageSizeBytes: 48000000,
  maxWriteBatchSize: 100000,
  localTime: ISODate('2024-08-23T10:53:26.923Z'),
  logicalSessionTimeoutMinutes: 30,
  connectionId: 20,
  minWireVersion: 0,
  maxWireVersion: 21,
  readOnly: false,
  ok: 1
}
```
* Reference - https://www.mongodb.com/docs/manual/tutorial/install-mongodb-community-with-docker/#std-label-docker-mongodb-community-install
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)