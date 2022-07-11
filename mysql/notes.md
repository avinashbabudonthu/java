## Disable Safe Mode
* Using command SET SQL_STATE_UPDATES = 1
* Using My SQL Workbench settings
	* Edit in file menu
	* Preferences
	* Click "SQL Editor" tab
	* Scroll down
	* Uncheck "Safe Updates" check box
	* Query in file menu - this will come if you already connected to any instance
	* Reconnect to server
	* logout and then login
	* Now execute your sql query
	
## Disable Safe Mode In AWS RDS
* Open the RDS web console
* Open the "Parameter Groups" tab
* Create a new Parameter Group. On the dialog, select the MySQL family compatible to your MySQL database version, give it a name and confirm. Select the just created Parameter Group and issue "Edit Parameters"
* Look for the parameter "log_bin_trust_function_creators" and set its value to "1"
* Save the changes
* Open the "Instances" tab. Expand your MySQL instance and issue the "Instance Action" named "Modify"
* Select the just created Parameter Group and enable "Apply Immediately"
* Click on "Continue" and confirm the changes
* Wait for the "Modifying" operation to be completed
* Again, open the "Instances" tab. Expand your MySQL instance and expand "Instance Action" tab and select "Reboot"

## Triggers
* Create Trigger
```
DELIMITER $$
create trigger t_sale_after_insert after insert on t_sale
for each row
begin
insert into t_audit(username, action, action_date_time, table_name, column_name, new_value, row_pk)
values (NEW.username, 'insert', CURRENT_TIMESTAMP(), 't_sale', 'lead_owner', NEW.lead_owner, NEW.id);
if(OLD.lead_owner <> NEW.lead_owner) then
insert into t_audit(username, action, action_date_time, table_name, column_name, new_value, old_value, row_pk)
values (NEW.username, 'update', CURRENT_TIMESTAMP(), 't_sale', 'lead_owner', NEW.lead_owner, OLD.lead_owner, NEW.id);
end if;
END$$
DELIMITER ;
```

# Data Types
* char
	* Fixed length
	* char
	* char(10) - maximum 10 character == 10 Bytes
	* Maximum 255 Bytes
* varchar
	* variable length
	* Maximum 65,535 Bytes
* enum
	* enum('M', 'F')
* tinyint
	* 1 byte
	* signed means values are -128 to 127
	* unsigned means values are 0 to 255
* smallint
	* 2 bytes
* mediumint
	* 3 bytes
* int
	* 4 bytes
* bigint
	* 8 bytes
* date
	* used to represent date in format `YYYY-MM-DD`
	* Time is not part of this representation
	* Values range - `1st of January 1000` to `31st of December 9999`
* datetime
	* used to represent data + time in format `YYYY-MM-DD HH:MM:SS[.fraction]`
* timestamp
	* used for well-defined, exact point in time
	* range - from `1st of January 1970 UTC` to `19th January 2038, 03:14:07 UTC`
	* UTC - Coordinated Universal Time
	* Records the moment in time as number of seconds passed after 1st January 1970 00:00:00 UTC
	* allows to easily obtain difference between 2 timstamp values
	* timestamp is appropriate to handle time zones
* blob
	* Binary Large Object
	* For saving files
	

# Floating point numbers
* Precision: number of digits in a number. For example for number 10.523 - precision is 5
* Scale: number of digits to the right of the decimal point in a number. For example for number 10.523 - scale is 3
* Data type: decimal(5,3)
	* 5 : Precision
	* 3 : Scale
* decimal(7) is same as decimal(7, 0)
* decimal == numeric. We can use anyone of them. Same T&C

# Fixed vs floating-point datatypes
* Fixed point
	* Represent exact values. decimal is good example
	* For decimal(5,3)
		* If we insert 10.523 - this exactly fits
		* If we insert 10.5 - this becomes 10.500
		* If we insert 10.523678 - this becomes 10.524 by rounding to ceil with warning
* Floating datatypes - float, double
	* Represent floating numbers like approximate values
	* For float(5, 3)
		* If we insert 10.523 - this exactly fits
		* If we insert 10.523678 - this becomes 10.524 by rounding to ceil but no warning

# Float vs Double
Floating point datatype  | Size(bytes) | precision | maximum number of digits
------------- | ------------- | ------------- | -------------
Float  	| 4	| single	| 23
Double  | 8	| double 	| 53

# Indexes
* Used to access records in table quickly
* It takes more time to update table because indexes has to be updated too
* syntax
```
create index index_name on i_table_name (column_1, column_2, ..);
```
* show indexes
```
show indexes from employees;
```

# Not Null constraint
* The `NOT NULL` constraint is a column constraint that ensures values stored in a column are not `NULL`
```
column_name data_type NOT NULL;
```
* A column may contain only one NOT NULL constraint which specifies a rule that the column must not contain any NULL value. In other words, if you update or insert NULL into a NOT NULL column, MySQL will issue an error. The following `CREATE TABLE` statement creates the emp table
```
CREATE TABLE emp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE
);
```
* In the tasks table, we explicitly define the title and start_date columns with NOT NULL constraints. The id column has the PRIMARY KEY constraint, therefore, it implicitly includes a NOT NULL constraint.
* The end_date column can have NULL values, assuming that when you create a new task, you may not know when the task can be completed.
* It’s a good practice to have the NOT NULL constraint in every column of a table unless you have a good reason not to do so.
* Generally, the NULL value makes your queries more complicated because you have to use functions such as ISNULL(), IFNULL(), and NULLIF() for handling NULL

# Not Null constraint to existing column
* Follow below steps
	* Check the current values of the column if there is any NULL
	* Update the NULL to non-NULL if NULLs exist
	* Modify the column with a NOT NULL constraint
```
ALTER TABLE table_name CHANGE old_column_name new_column_name column_definition;

ALTER TABLE emp CHANGE end_date end_date DATE NOT NULL;
```

# Drop Not Null constraint
* Use `Alter Table.. modify` statement
```
ALTER TABLE table_name MODIFY column_name column_definition;
```
* Column definition (column_definition) must restate the original column definition without the NOT NULLconstraint
* Following statement removes the NOT NULL constraint from the end_date column in the emp table
```
ALTER TABLE tasks MODIFY end_date end_date DATE NOT NULL;
```

# Composite primary key
* Using `alter`
* Create table
```
create table t_student
(
	id int,
	name varchar(100),
	age int
);
```
* Add composite primary key
```
ALTER table t_student add primary key(id, name);
```

# Coding styles
* when assigning names to sql object use `shorter, meaningful` names
* sql key words in capial case
* object names, column names in lower case
* object names, column names with multiple words separated with `underscore(_)`
* readability
	* Organize sql query horizontally and vertically
	* sql names in blue color
	* object names in black color
* use comments

# Coding techniques
* Use `ad-hoc` tools that reorganizes code, colors different words of the code
* use tools provided in workbench
* Intevene and adjust as we like

# Variables
* 3 types of variables
	* local
	* session
	* global
* local variables
	* variables declared between `BEGIN` and `END`
	* `DECLARE` key word is used to declare local variables only
* session variables
	* each connection is called `session`
	* variables created in one session are not visible in another session
	* `SET` key word is used to declare session variables
	* variable must start with `@`
	* If we declare variable `@v_avg_salary`, then get it's value using simple select `select @v_avg_salary;`
* global variables
	* ways to declare variables `set global v_var_name = value; (or) set @@global.v_var_name = value;`
	* we cannot just set any variables as global variables
	* only `system variables` are allowed to set as global variables like
		* .max_connections() - maximum number of connections to server that can establish at certain point of time
			* SET GLOBAL max_connections = 1000;
			* SET @@global.max_connections = 1000;
		* .max_join_size() - maximum memory space allocated for the joins created by certain connection