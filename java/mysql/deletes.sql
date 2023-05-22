-- use employees database
use employees;

-- Remove the department number 10 record from the “departments” table
select * from departments;
delete from departments where dept_no = 'd010';
rollback;
commit;

-- remove all records from departments table
truncate departments;