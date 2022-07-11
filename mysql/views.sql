-- use employees database
use employees;

-- syntaxt
-- create or replace view v_view_name as
-- select
-- 	column_1, colunm_2 
-- from
-- 	table_name;

-- create view
create or replace view v_employees_departments as
select emp_no, max(from_date) as from_date, max(to_date) as to_date
from dept_emp group by emp_no;

-- execute above view
select * from v_employees_departments;