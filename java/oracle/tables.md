## Create Alter Modify Rename Drop  Table And Column Scripts
## Create Table Scripts
* Table creation with BLOB column and specify column size
```
create table pictures(name varchar(32) not null primary key, pic blob(16M));
```
* Create table with BLOB column. Do not specify the column size
```
CREATE TABLE a_table (blob_col BLOB);
```
* Create table with CLOB column
```
CREATE TABLE a_table (blob_col CLOB);
```

## Alter Table Scripts
* Add Columns to Table
```
ALTER TABLE table_name ADD column_name column-definition;

ALTER TABLE customers ADD customer_name varchar2(45);
```
* Add column with default value
```
ALTER TABLE customers ADD city varchar2(40) DEFAULT 'Hyderabad';
```
* Add Multiple columns in a table
```
ALTER TABLE table_name
  ADD (column_1 column-definition,
       column_2 column-definition,
       ...
       column_n column_definition);
	   
ALTER TABLE customers
  ADD (customer_name varchar2(45),
       city varchar2(40) DEFAULT 'Hyderabad');
```

## Modify Scripts
* Modify Column
```
ALTER TABLE table_name MODIFY column_name column_type;

ALTER TABLE table_name MODIFY COLUMN column_name datatype; // prior version 10G

ALTER TABLE table_name MODIFY column_name datatype; // oracle 10G and later

ALTER TABLE customers MODIFY customer_name varchar2(100) NOT NULL;

ALTER TABLE customers MODIFY city varchar2(75) DEFAULT 'Hyderabad' NOT NULL;
```
* Modify Multiple columns
```
ALTER TABLE table_name
  MODIFY (column_1 column_type,
          column_2 column_type,
          ...
          column_n column_type);
		  
ALTER TABLE customers
  MODIFY (customer_name varchar2(100) NOT NULL,
          city varchar2(75) DEFAULT 'Hyderabad' NOT NULL);
```

## Drop Scripts
* Drop Column
```
ALTER TABLE table_name DROP COLUMN column_name;

ALTER TABLE customers DROP COLUMN customer_name;
```
* Drop Table
```
DROP TABLE JOB IF EXISTS;
```

## Rename Scripts
* Rename column
```
ALTER TABLE table_name RENAME COLUMN old_name TO new_name;

ALTER TABLE customers RENAME COLUMN customer_name TO cname;
```
* Rename Table
```
ALTER TABLE table_name RENAME TO new_table_name;

ALTER TABLE customers RENAME TO contacts;
```
