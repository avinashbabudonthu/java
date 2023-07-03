# Protobuf Java example 1
* Write proto files
  * [addressBook.proto](files/addressBook.proto)
  * [theater.proto](files/theater.proto)
* Download `protoc-23.3-win64.zip` from https://github.com/protocolbuffers/protobuf/releases/tag/v23.3
* Generate `java` classes to above `proto` files using above `protoc`
```
protoc -I=. --java_out=./proto-src addressBook.proto
protoc --proto_path=. --java_out=./proto-src theater.proto
```
* Some errors to understand - for knowledge
```
protoc -I=. --java_out=. --proto_path=./theater.proto
Missing input file.

protoc --proto_path=. --java_out=. theater.proto
theater.proto:3:9: Expected identifier.
--> This is because package is given in double in proto file

protoc --proto_path=. --java_out=. theater.proto
theater.proto:10:18: Required fields are not allowed in proto3.
theater.proto:11:18: Required fields are not allowed in proto3.

protoc --proto_path=. --java_out=. theater.proto
--java_out: theater.proto: theater.proto: Cannot generate Java output because the file's outer class name, "Theater", matches the name of one of the types declared inside it.  Please either rename the type or use the java_outer_classname option to specify a different outer class name for the .proto file.
```
* Add `protobuf-java` dependency in [pom.xml](pom.xml). We should add compatible `protobuf-java` version with `protoc` used to genera java files
* Test classes
  * [AddressBookProtosTest](src/test/java/com/protobuf/AddressBookProtosTest.java)
    * create
    * write - serialize
    * read - deserialize
  * [TheaterTest](src/test/java/com/protobuf/TheaterTest.java)
    * create
    * write - serialize
    * read - deserialize