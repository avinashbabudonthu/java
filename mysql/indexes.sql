-- use employees database
use employees;

## syntax
## create index index_name on i_table_name (column_1, column_2, ..);

## show indexes
SHOW INDEXES FROM employees;

## drop index
ALTER TABLE employees DROP INDEX i_hire_date;

## create index on salary column and see if index sped up the query execution time or not
SELECT * FROM salaries WHERE salary > 89000;
CREATE INDEX i_salary ON salaries(salary);
SELECT * FROM salaries WHERE salary > 89000;
SHOW INDEXES FROM salaries;
ALTER TABLE salaries DROP INDEX i_salary;