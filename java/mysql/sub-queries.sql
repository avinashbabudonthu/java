-- use employees database
use employees;

-- exists
-- check whether certain row values are found within sub query
-- this check conducted row by row
-- exists returns boolean value4
-- first and last name of employees who are department managers
select e.first_name, e.last_name from 
employees e where exists (select * from dept_manager d where d.emp_no = e.emp_no);

