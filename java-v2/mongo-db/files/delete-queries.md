### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Delete Commands
* Delete collection
```
db.[collection].drop()
db.employees.drop()
```
* Delete all documents in collection
```
db.emp.deleteMany({})
```
* Remove document with name = jack
```
db.emp.delete({name: "jack"})
```
* Remove field in existing document
```
{
    "_id" : ObjectId("60288cb4453eab070f119248"),
    "firstName" : "jack",
    "lastName" : "a",
    "age" : 25.0,
    "contactNumbers" : [ 
        1234567890.0, 
        987654321.0
    ],
    "address" : {
        "hno" : "7-8-9",
        "street" : "test-street",
        "district" : "test-district",
        "state" : "test-state",
        "country" : "test-countrye"
    },
    "hno" : "7-8-9"
}

db.emp.update({"age": 25}, {$unset: {hno: 1}} )
```
* Remove field in multiple documents where age = 25
```
db.emp.update({"age": 25}, {$unset: {"hno": 1}}, {"multi": true} )
db.emp.updateMany({"age": 25}, {$unset: {hno: 1}} )
db.emp.update({"age": 25}, {$unset: {hno: 1}}, false, true ) //The last true is for multiple documents update
```
* Remove key in all documents
```
db.emp.update({}, {$unset: {"hno": 1}}, {"multi": true} )
db.emp.updateMany({}, {$unset: {hno: 1}} )
db.emp.update({}, {$unset: {hno: 1}}, false, true ) //The last true is for multiple documents update
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)