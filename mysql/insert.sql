-- use employees database
use employees;

-- insert data from table_1 to table_2
-- insert into table_2 (column_1, column_2, column_3) select column_1, column_2, column_3 from table_1 where condition;
-- create departments_dup. copy all data from departments table to departments_dup
select * from departments;
create table departments_dup
(
	dept_no char(5) not null,
    dept_name varchar(40) not null
);
select * from departments_dup;
insert into departments_dup (dept_no, dept_name) select dept_no, dept_name from departments;
commit;

-- Create a new department called “Business Analysis”. Register it under number ‘d010’.
insert into departments (dept_no, dept_name) values ('d010', 'Business Analysis');
commit;
select * from departments;