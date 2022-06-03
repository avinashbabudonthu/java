# AVRO Notes

## Evolution of data formats
* CSV
* Relational Tables
* XML
* JSON
* AVRO

### CSV - Comma Separated Values
* Advantages
	* Easy to parse
	* Easy to read
* Dis Advantages
	* Data types not present
	* Parsing is tricky if data contains commas
	* Column names may or may not be there

### Relational Tables
* Example
```
create table emp(
	id number,
	name varchar(50)
);
```
* Advantages
	* Data fits in table
* Dis Advantages
	* Data has to be flat (row and columns). No nesting
	* Data is stored in database. So definition will be different for each database
	
### XML

### JSON - Javascript Object Notatio
* Examples
```
{
	"id" : 100,
	"name": "avia"
}
```
* Advantages
	* Data can take any form like arrays, nested elements
	* Widely accepted. Every language has parsers
	* Easily shared across network
* Dis Advantages
	* No schema enforcing
	* Can be really big in size because of repeated keys

### AVRO
* Avro is defined by schema. Shema is written in JSON
* We can view Avro as JSON with schema attached to it
```
{
	"type": "record",
	"name": "employee",
	"namespace": "my.employees",
	"fields": [
		{
			"name": "firstName",
			"type": "string",
			"default": "None"
		},
		{
			"name": "age",
			"type": "int",
			"default": -1
		},
		{
			"name": "address",
			"default": {},
			"type": {
				"type": "record",
				"name": "mail-address",
				"fields": [
					{
						"name": "street",
						"type": "string",
						"default": "None"
					},
					{
						"name": "city",
						"type": "string",
						"default": "None"
					}
				]
			}
		}
	]
}
```
* Advantages
	* Data is fully typed
	* Data is compressed automatically. So less CPU space usage
	* Schema comes along with data
	* Documentation is embedded in schema
	* Data can be read across any language
* Dis Advantages
	* Avro support for some languages may be lacking
	* Can't print the data without using Avro tools because it's compressed and serialized
	
### Avro vs Protobuf vs Thrift vs Parquet vs ORC etc
* Overall, all these data formats achieve pretty much same goal
* At kafka level we prefer Avro because we care about message being self explanatory and fully described as we are dealing with streaming
* Avro has good support from Hadoop based technologies like Hive
* Avro has choosen as the only supported data format from Confluent Schema Registry

## Features of Avro
* Avro is a language-neutral data serialization system.
* It can be processed by many languages (currently C, C++, C#, Java, Python, and Ruby).
* Avro creates binary structured format that is both compressible and splittable. Hence it can be efficiently used as the input to Hadoop MapReduce jobs.
* Avro provides rich data structures. For example, you can create a record that contains an array, an enumerated type, and a sub record. These datatypes can be created in any language, can be processed in Hadoop, and the results can be fed to a third language.
* Avro schemas defined in JSON, facilitate implementation in the languages that already have JSON libraries.
* Avro creates a self-describing file named Avro Data File, in which it stores data along with its schema in the metadata section.
* Avro is also used in Remote Procedure Calls (RPCs). During RPC, client and server exchange schemas in the connection handshake.

## Working of Avro
* Step 1 − Create schemas. Here you need to design Avro schema according to your data.
* Step 2 − Read the schemas into your program. It is done in two ways −
	* By Generating a Class Corresponding to Schema − Compile the schema using Avro. This generates a class file corresponding to the schema
	* By Using Parsers Library − You can directly read the schema using parsers library.
* Step 3 − Serialize the data using the serialization API provided for Avro, which is found in the package org.apache.avro.specific.
* Step 4 − Deserialize the data using deserialization API provided for Avro, which is found in the package org.apache.avro.specific.

## What is Serialization
* Serialization is the process of translating data structures or objects state into binary or textual form to transport the data over network or to store on some persisten storage. Once the data is transported over network or retrieved from the persistent storage, it needs to be deserialized again. Serialization is termed as `marshalling` and deserialization is termed as `unmarshalling`

## AVRO Schemas
* Describe following details
	* type of file. `record` by default
	* location of record
	* name of the record
	* fields in the record with their corresponding data types
### Schema contains
* type
* name
* namespace
* fields
* default
```
{
   "type" : "record",
   "namespace" : "Cerebro",
   "name" : "Student",
   "fields" : [
      { "name" : "Name" , "type" : "string" },
      { "name" : "Age" , "type" : "int" }
   ]
}
```
* type: This field comes under the document as well as the under the field named `fields`
	* In case of document, it shows the type of the document, generally a `record` because there are multiple fields
	* When it is field, the type describes data type
* name: This field comes under the document as well as the under `fields`
	* In case of document, it describes the schema name. This schema name together with the namespace, uniquely identifies the schema within the store (Namespace.schema-name). In the above example, the full name of the schema will be `Cerebro.Student`
	* In case of fields, it describes name of the field
* namespace: This field describes the name of the namespace in which the object resides. This is `package` of generated class

### Primitive data types of Avro
Data Type 		| Description
----------		| ------------------
null			| No Value
int				| 32-bit signed integer
long			| 64-bit signed integer
float 			| single precision (32-bit) floating point number
double			| double precision (64-bit) floating point number
bytes			| sequence of 8-bit unsigned bytes
string			| Unicode character sequence

### Complex data types
* Record
* Enum
* Array
* Map
* Union
* Fixed

#### Record
* record data type in Avro is a collection of multiple attributes
* It supports following attributes
	* name: value of this field holds the name of the record
	* namespace: value of this field holds the name of the namespace where the object is stored
	* type: value of this attribute holds either the type of the document (record) or the datatype of the field in the schema
	* fields: field holds a JSON array, which have the list of all of the fields in the schema, each having name and the type attributes
```
{
	"type" : "record",
	"namespace" : "Cerebro",
	"name" : "Student",
	"fields" : [
		{ "name" : "Name" , "type" : "string" },
		{ "name" : "age" , "type" : "int" }
	]
}
```

#### Enum
* enumeration is a list of items in a collection
* It supports following attributes
	* name: value of this field holds the name of the enumeration
	* namespace: value of this field contains the string that qualifies the name of the Enumeration
	* symbols: value of this field holds the enum's symbols as an array of names
```
{
   "type" : "enum",
   "name" : "Numbers", 
   "namespace": "data", 
   "symbols" : [ "ONE", "TWO", "THREE", "FOUR" ]
}
```

#### Array
* data type defines an array field having a single attribute `items`
* `items` attribute specifies the type of items in the array
```
{ "type" : "array", "items" : "int" }
```

#### Map
* map data type is an array of key-value pairs, it organizes data as key-value pairs
* The key for an Avro map must be a string
* The values of a map hold the data type of the content of map
```
{"type" : "map", "values" : "int"}
```

#### Union
* union datatype is used whenever the field has one or more datatypes
* They are represented as JSON arrays
* For example, if a field that could be either an int or null, then the union is represented as ["int", "null"]
```
{ 
   "type" : "record", 
   "namespace" : "cerebro", 
   "name" : "employee", 
   "fields" : 
   [ 
      { "name" : "experience", "type": ["int", "null"] }, { "name" : "age", "type": "int" } 
   ] 
}
```

#### Fixed
* data type is used to declare a fixed-sized field that can be used for storing binary data
* It has field name and data as attributes
* Name holds the name of the field, and size holds the size of the field
```
{ "type" : "fixed" , "name" : "bdata", "size" : 1048576}
```

## APIs
class														| Description
-------------------------------								| --------------------------------------------
org.apache.avro.specific.SpecificDatumWriter				| implements the DatumWriter interface. converts Java objects into an in-memory serialized format
org.apache.avro.specific.SpecificDatumReader				| implements the DatumReader interface. reads the data of a schema and determines in-memory data representation. SpecificDatumReader is the class which supports generated java classes
DataFileWriter												| class writes a sequence serialized records of data conforming to a schema, along with the schema in a file
DataFileReader												| class provides random access to files written with DataFileWriter. It inherits the class `DataFileStream`
org.apache.avro.Schema.Parser								| class is a parser for JSON-format schemas. It contains methods to parse the schema
GenricRecord Interface										| provides methods to access the fields by name as well as index. `Object get(String key)` - Returns the value of a field given. `void put(String key, Object v)` - Sets the value of a field given its name
GenericData.Record											| Constructor - `GenericData.Record(Schema schema)`

## GenericData.Record methods
* Object get(String key) - Returns the value of a field of the given name
* Schema getSchema() - Returns the schema of this instance
* void put(int i, Object v) - Sets the value of a field given its position in the schema
* void put(String key, Object value) - Sets the value of a field given its name

## Avro Serialization By Generating class
* Read avro schema into program by either of the following
	* Generating class corresponding to schema
	* using parser library
### Serialize data
* Write an Avro schema.
* Compile the schema using Avro utility. You get the Java code corresponding to that schema.
* Populate the schema with the data.
* Serialize it using Avro library