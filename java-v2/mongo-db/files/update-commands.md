### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Update Commands
* Update document. set age to 25 where age = 24
```
db.emp.update({"age": 24}, {$set: {"age": 25}})
```
* Update multiple documents. Update name where age = 25
```
db.emp.update({"age": 25}, {$set: {"name": "new name"}}, {"multi": true})
```
* Update nested field
```
db.emp.insert({
 "firstName": "jack", "lastName": "a", "age": 25, "contactNumbers": [1234567890, 0987654321], 
 "address": {"hno": "1-2-3", "street": "test-street", "district": "test-district", "state": "test-state", "country": "test-countrye"}
})

{
    "_id" : ObjectId("602891cf453eab070f11924b"),
    "firstName" : "jack",
    "lastName" : "a",
    "age" : 25.0,
    "contactNumbers" : [ 
        1234567890.0, 
        987654321.0
    ],
    "address" : {
        "hno" : "1-2-3",
        "street" : "test-street",
        "district" : "test-district",
        "state" : "test-state",
        "country" : "test-countrye"
    }
}

db.emp.update({"age": 25}, {$set: {"address.hno": "7-8-9"}})
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)