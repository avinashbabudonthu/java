### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Read Commands
* All documents
```
db.emp.find()
```
* Find one document
```
db.students.findOne({})
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
```
* Count
```
db.employee.count()  -> DeprecationWarning: Collection.count() is deprecated. Use countDocuments or estimatedDocumentCount

db.employee.countDocuments()
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)