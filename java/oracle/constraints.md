## Check Constraints
* Constraint along with column
```
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int CHECK (Age&gt;=18)
);
```
* Check Constraint with IN clause along with column
```
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
	Active number(1,0) CHECK (Active in (1,0))    
);
```
* Declare constraint separately
```
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    City varchar(255),
    CONSTRAINT CHK_Person CHECK (Age&gt;=18 AND City='Hyderabad')
);

CREATE TABLE suppliers
(
  supplier_id numeric(4),
  supplier_name varchar2(50),
  CONSTRAINT check_supplier_name
  CHECK (supplier_name = upper(supplier_name))
);
```
* Alter table add check constraint
```
ALTER TABLE Persons ADD CHECK (Age&gt;=18);

ALTER TABLE Persons ADD CONSTRAINT CHK_PersonAge CHECK (Age>=18 AND City='Hyderabad');

ALTER TABLE suppliers ADD CONSTRAINT check_supplier_name CHECK (supplier_name IN ('IBM', 'Microsoft', 'NVIDIA'));
```
* Enable Check constraint
```
ALTER TABLE table_name ENABLE CONSTRAINT constraint_name;

ALTER TABLE suppliers ENABLE CONSTRAINT check_supplier_id;
```
* Disable check constraint
```
ALTER TABLE table_name DISABLE CONSTRAINT constraint_name;

ALTER TABLE suppliers DISABLE CONSTRAINT check_supplier_id;
```
* Drop check constraint
```
ALTER TABLE Persons DROP CONSTRAINT CHK_PersonAge;
```
