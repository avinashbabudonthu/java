### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Practice Collections and Data
* use database
```
use practicedb1
```
* Check current db
```
db
```
* Create collections
```
db.createCollection("students")
db.createCollection("employees")
```
* insert data to `employees` collection
```
db.employees.insertMany([
{"id": 1, "name": "a","dept": "d1"},
{"id": 2, "name": "b","dept": "d2"},
{"id": 3, "name": "c","dept": "d3"},
{"id": 4, "name": "d","dept": "d4"},
{"id": 5, "name": "e","dept": "d5"},
{"id": 6, "name": "f","dept": "d6"},
{"id": 7, "name": "g","dept": "d7"},
])
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)