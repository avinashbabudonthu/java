### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# DB Commands
* Run mongodb by giving db path
```
mongod.exe --dbpath C:\mongodb\data\db
```
* Help
```
help
```
* Show dbs
```
show dbs
show databases
```
* Use specific db
```
use <database-name>
use office
```
* Show collections
```
show collections
```
* Show users
```
show users
```
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

------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)