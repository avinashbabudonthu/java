# Materials in study order
* https://www.baeldung.com/google-protocol-buffer
------
# Installation
* Download protobuf - https://github.com/protocolbuffers/protobuf/releases
* Download file - `protoc-[version]-[os].zip`
* Extract
* Execute below command to generate source file from proto file
```
protoc -I=C:\..\proto-files --java_out=C:\..\proto-files myFile.proto
```
* `protoc` command will generate Java output file from our `myFile.proto` file
* `-I` option specifies a directory in which a proto file resides
* `java-out` specifies a directory where the generated class will be created
------