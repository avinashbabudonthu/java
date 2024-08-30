### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Create Commands
* Create collection
```
use office
db.createCollection("employees")
show collections

or
use office
db.createCollection("emp", { capped: true, autoIndexID: true, size: 6142800, max: 100000 })
show collections
```
* Drop collection
```
db.collection.drop()
```
* Insert document
```
db.[collection].insert([document-json])
db.emp.insert({"name": "jack"})

db.emp.insert({"name": "john", "age": 21, "dept": "accounts"})
db.emp.save({"name": "john", "age": 21, "dept": "accounts"})

db.emp.insert({
"firstName": "jack", "lastName": "a", "age": 25, 
"contactNumbers": [1234567890, 0987654321], 
"address": {"hno": "1-2-3", "street": "test-street", "district": "test-district", "state": "test-state", "country": "test-countrye"}
})

db.[collection].insertOne([document-json])
db.emp.insertOne({"name": "jack"})

db.emp.insertOne({"_id":"100abcd", "name": "jack"})
```
* Insert multiple documents
```
db.emp.insert([
{
    "name": "jane",
    "age": 23
},
{
    "name": "smith",
    "age": 24
}
])
```
```
db.emp.insertMany([
{"id": 1, "name": "a","dept": "d1"},
{"id": 2, "name": "b","dept": "d2"}
])
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)