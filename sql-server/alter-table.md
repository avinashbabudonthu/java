# Alter table
* The ALTER TABLE statement is used to add, delete, or modify columns in an existing table
* The ALTER TABLE statement is also used to add and drop various constraints on an existing table
## ALTER TABLE - ADD Column
```
ALTER TABLE table_name ADD column_name datatype;
ALTER TABLE Customers ADD Email varchar(255);
```
## ALTER TABLE - DROP COLUMN
* To delete a column in a table, use the following syntax (notice that some database systems don't allow deleting a column)
```
ALTER TABLE table_name DROP COLUMN column_name;
```
* The following SQL deletes the "Email" column from the "Customers" table
```
ALTER TABLE Customers DROP COLUMN Email;
```
## ALTER TABLE - ALTER/MODIFY COLUMN
* To change the data type of a column in a table
```
ALTER TABLE table_name ALTER COLUMN column_name datatype;
```

## DROP COLUMN Example
```
ALTER TABLE Persons DROP COLUMN DateOfBirth;
```