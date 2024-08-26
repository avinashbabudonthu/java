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
* Create db. Use specific db. There is no `create` command for database. `use` will command will create and switch to dbs. If we run `show dbs` then new db is not visible. New db will be visible after 1st document insertion to any collection that db
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