-- use employees database
use employees;

-- 0 in params, n out params
-- Create store procedure
delimiter //
create procedure find_all_employees()
begin
	select e.empno, e.ename, e.job, e.sal, e.comm, e.mgr,e.hiredate, d.deptno, d.dname, d.loc from emp e join dept d on e.deptno = d.deptno;
end //
delimiter ;

-- call store procedure
call find_all_employees;

-- drop stored procedure
drop procedure if exists find_all_employees;


-- 1 in param and n out params
-- create stored procedure
delimiter //
create procedure find_employee_by_dept_id(in dept_id_in int)
begin
	select e.empno, e.ename, e.job, e.sal, e.comm, e.mgr,e.hiredate, d.deptno, d.dname, d.loc 
		from emp e join dept d 
        on e.deptno = d.deptno
        where d.deptno = dept_id_in
    ;
end //
delimiter ;

-- drop stored procedure
drop procedure if exists find_employee_by_dept_id;

-- call stored procedure
call find_employee_by_dept_id(10);
call find_employee_by_dept_id(20);
call find_employee_by_dept_id(30);
call find_employee_by_dept_id(40);

-- stored procedure return result from multiple selects
-- create stored procedure
delimiter //
create procedure find_employees_and_depts()
begin
	select * from emp;
    
    select * from dept;
end //
delimiter ;

-- drop stored procedure
drop procedure if exists find_employees_and_depts;

-- call stored procedure
call find_employees_and_depts;

-- Drop
-- DROP PROCEDURE if exists [procedure-name];
DROP PROCEDURE if exists sp_find_person;

-- stored procedure with 1 input and 1 output parameter
delimiter //
create procedure employees_avg_salary_out(in p_emp_no integer, out p_avg_salary decimal(10, 2))
begin
	select avg(s.salary) into p_avg_salary from employees e join salaries s on e.emp_no = s.emp_no where e.emp_no = p_emp_no;
end //
delimiter ;

set @V_avg_salary = 0;
call employees_avg_salary_out(11300, @V_avg_salary);
select @V_avg_salary;