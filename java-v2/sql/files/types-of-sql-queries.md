### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Types of SQL Queries
------
* SQL queries can be categorized into 5 categories based on the purpose of the user:
	* DDL- Data Definition Language
	* DML- Data Manipulation Language
	* DQL- Data Query Language
	* DCL- Data Control Language
	* TCL- Transaction Control Language
------
# DDL- Data Definition Language
* Data Definition Language defines the actual creation modifications, renaming, and dropping (deleting) of the tables, rows, or columns. This type uses basic queries. Any creation of a table starts with this type. Let's see some examples of DDL
```
-- Creating the table
-- We can use CREATE TABLE statement
CREATE TABLE table1
(col1 INT IDENTITY(1,1),
col2 VARCHAR(100),
col3 VARCHAR(100),
col4 VARCHAR(20)
)

-- rename the column 
ALTER TABLE table1
RENAME COLUMN col1 To col1_1

--add column 
ALTER TABLE table1
ADD COLUMN col5

--drop column 
ALTER TABLE table1
DROP COLUMN col4

-- drop the table from schema. delete the table from the schema
DROP TABLE table1
```
------
# DML- Data Manipulation Language
* DML is basically the manipulation of tables and columns. In this type, we use `INSERT, UPDATE, DELETE, EXPLAIN, EXECUTE, LOCK` etc. Manipulation means we can manipulate the table rows and columns, We can insert new records, update the value of the specific value, delete specific records in the table, and execute the specific stored procedures. We can see the meaning of the stored procedure in some other blog
```
INSERT INTO statement for inserting the new record or row
INSERT INTO table1 (col1, col2, col3, col4)
VALUES (4,'Peanut Butter','Butter','A-19')

-- Updating the specific record in the tbale
UPDATE table1
SET col1 = 'Milk',col2 = 'Dairy Product'
WHERE SrNo = 4

--DELETE records for specific SrNo 
DELETE FROM table1
where SrNo=4

--EXECUTE command to run stored procedure
EXUCUTE StoredProcedurename
(Parameters if any)
```
------
# DQL- Data Query Language
* The data query language is the most common and important type of language in SQL. It is important because all queries should start with the SELECT word.
```
SELECT * FROM table1
-- The above query will select all t he orws from the table
-- '*' means that give the all the rows that are in the table

-- SELECT to make some arithmetic calculations as well. This will give us output as 200
SELECT (100+100)

--What is Alias? Alias is the naming that we give to the output. We want to give name to above output, we will give.
SELECT (100+100) as total
```
------
# DCL- Data Control Language
* Data Control Language is used to control the access to the database tables, views, stored procedures, and many more objects in SQL Server. DCL Commands are the most useful commands when it comes to the security of the database
* There are two types of privileges: 
	* System Privilege
	* Object Privilege
* DCL is important so that unauthorized people cannot access the data. There are 2 most important DCL commands:
	* GRANT 
	* REVOKE
* GRANT is used to grant permission to a particular object. The example can be that if we don’t want anyone to access the views, they will not see the views. Or just permission to view but not to update the data.
```
GRANT privilege_list
ON object_name
TO user_name
```
* REVOKE is used to remove permission from the user. If you want the users to return the permission that you granted in past, you can use REVOKE.
```
REVOKE privilege_list
ON object_name
TO user_name
```
------
# TCL- Transaction Control Language
* TCL are the commands which are used to make the data consistent in the server database. Whenever we execute some SQL Statements in the DBMS (Data Base Management System) it is called a transaction. These transactions are temporary in SQL, so in order to make them permanent, we use TCL commands.
* Basic commands used are: 
	* COMMIT
	* ROLLBACK
	* SAVEPOINT
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)