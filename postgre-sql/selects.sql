-- select all records from table
select * from emp;
select * from dept;
select * from salgrade;

-- Describe
select column_name from information_schema.columns where table_name = 'emp';