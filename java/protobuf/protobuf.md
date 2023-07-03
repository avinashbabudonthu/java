# Materials in study order
* https://www.baeldung.com/google-protocol-buffer
* https://protobuf.dev/getting-started/javatutorial/
* https://www.tutorialspoint.com/protobuf/index.htm
------
# Installation
* Download protobuf - https://github.com/protocolbuffers/protobuf/releases
* Download file - `protoc-[version]-[os].zip`
* Extract
* Execute below command to generate source file from proto file
```
protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/myFile.proto
protoc -I=C:\..\proto-files --java_out=C:\..\proto-files myFile.proto
```
* `protoc` command will generate Java output file from our `myFile.proto` file
* `-I` option specifies a directory in which a proto file resides
* `java-out` specifies a directory where the generated class will be created
------
# Data types and keywords in proto file
* syntax - version of protobuf. Values like `proto2`,`proto3`
* message - class name
* string - Java String
* int32 - int
* int64 - long
* float - float
* double - double
* bool - Boolean
* enum
```
syntax = "proto3";
package theater;
option java_package = "com.tutorialspoint.theater";
      
message Theater {
   enum PAYMENT_SYSTEM{
      CASH = 0;
      CREDIT_CARD = 1;
      DEBIT_CARD = 2;
      APP = 3;  
   }
   PAYMENT_SYSTEM payment = 7;
}
```
* repeated - list. message class contains a list for snacks
```
syntax = "proto3";
package theater;
option java_package = "com.tutorialspoint.theater";

message Theater {
   repeated string snacks = 8;
}
```
* map<string, int32> - java.util.Map
```
syntax = "proto3";
package theater;
option java_package = "com.tutorialspoint.theater";

message Theater {
   map<string, int32> movieTicketPrice = 9;
}
```
* Nested classes
```
syntax = "proto3";
package theater;
option java_package = "com.tutorialspoint.theater";

message Theater {
   TheaterOwner owner = 10;
}
message TheaterOwner{
   string name = 1;
   string address = 2;
}
```
