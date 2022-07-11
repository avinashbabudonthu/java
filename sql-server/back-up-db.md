# Backup database

* Full backup database to disk
```
backup database db1 to disk = 'filePath';
backup database db1 to disk = 'D:\backups\testDB.bak';
```
* Backup database with differential. A differential back up only backs up the parts of the database that have changed since the last full database backup.
```
backup database db1 to disk = 'filePath' with differential;
backup database db1 to disk = 'D:\backups\testDB.bak' with differential;
```