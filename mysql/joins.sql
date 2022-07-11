-- use employees database
use employees;

-- inner join on dept_no
select d.dept_no, d.dept_name, m.emp_no from dept_manager_dup m inner join departments_dup d on m.dept_no = d.dept_no;
-- get employess where anual salary is greater than 145000
select e.emp_no, e.first_name, e.last_name, s.salary from employees e join salaries s on e.emp_no = s.emp_no where s.salary > 145000;

-- cross join : takes the values from one table and connect them with all the values from the tables we want to join it with
-- connects all the values, not just the match
-- Catesian product of the values of 2 or more sets(tables)

-- get avergate salary by gender
select e.gender, avg(s.salary) as average_salary from employees e join salaries s on e.emp_no = s.emp_no group by e.gender;