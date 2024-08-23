### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Create Commands
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
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)