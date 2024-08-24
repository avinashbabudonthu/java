### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Read Commands
* All documents
```
db.emp.find()
```
* Documents with name = jack
```
db.emp.find( {name: "jack"} )
db.emp.find( {"name": "jack"} )
```
* Document by id
```
db.emp.find({"_id": ObjectId("6028904d453eab070f119249")})
db.emp.find(ObjectId("6028904d453eab070f119249"))
db.emp.findOne("6028904d453eab070f119249")
```

------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)