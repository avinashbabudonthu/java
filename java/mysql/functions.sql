-- use employees database
use employees;

-- what is the difference between stored procedure and functions?
-- Stored procedures will have output parameter(s) where functions do not have output prameter(s). After function object all parameters 
-- are input parameters, so we don't need to explicitely specify in, writing parameter name and datatype is enough. 
-- Though functions does not have output parameters, they can return value. It can be of any datatype.  
-- must always return a value. so function cannot be used for insert, update, delete operations

-- create function
delimiter //
create function f_emp_avg_salary(p_emp_no integer) returns decimal(10, 2)
begin
declare v_avg_salary decimal(10, 2);
select avg(s.salary) into v_avg_salary from employees e join salaries s on e.emp_no = s.emp_no where e.emp_no = p_emp_no;
return v_avg_salary;
end //
delimiter ;

-- drop function
drop function if exists f_emp_avg_salary;

-- call function
select f_emp_avg_salary(11300);