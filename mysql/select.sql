-- All these queries are from database created using employees-database-practice.sql
-- Refer employees-database-practice.sql and create database before executing these queries

-- use employees database
use employees;

-- select all rows and columns from table
-- select * from table_name;
select * from employees;
select * from departments;
select * from salaries;

select first_name, last_name from employees;
select dept_no from departments;

-- count number of rows
select count(*) from employees;
select count(first_name) from employees where first_name is null;
select count(first_name) from employees where first_name is not null;
select count(distinct first_name) from employees;
select count(*) from salaries where salary > 100000;
-- How many departments are there in the “employees” database
select count(distinct dept_no) from dept_emp;

-- sum
-- What is the total amount of money spent on salaries for all contracts starting after the 1st of January 1997
select sum(salary) from salaries where from_date > '1997-01-01';

-- max
select max(salary) from salaries;
-- Which is the highes employee number
select max(emp_no) from employees;

-- min
select min(salary) from salaries;
-- Which is the lowest employee number
select min(emp_no) from employees;

-- max and min in single query
select max(salary), min(salary) from salaries;

-- average
select avg(salary) from salaries;
-- What is the average annual salary paid to employees who started after the 1st of January 1997
select avg(salary) from salaries where from_date > '1997-01-01';

-- round
select round(avg(salary)) from salaries; -- round to integer
select round(avg(salary), 2) from salaries; -- 2 decimals

-- ifnull
select dept_no, dept_name, ifnull(dept_manager, 'Not Provided') as dept_manager from departments_dup;
select dept_no, dept_name, ifnull(dept_manager, concat(dept_no, '-', dept_name)) as dept_manager from departments_dup;

-- COALESCE
-- if 1st argument column value is null then returns 1st non null value from 2nd argument
select dept_no, dept_name, coalesce(dept_manager, dept_name, dept_no,  'Not Provided') as dept_manager from departments_dup;

-- Concatenate 2 varchar
select concat(first_name, '-', last_name) as name from employees;

-- where
select * from employees where emp_no = 10001;
select * from employees where first_name = 'Denis';
select * from employees where first_name = 'Kellie' and gender ='F';
select * from employees where first_name = 'Aruna' or first_name ='Kellie';
select * from employees where gender = 'F' and (first_name = 'Kellie' or first_name = 'Aruna');

-- in clause
select * from employees where first_name in ('Denis', 'Elvis', 'Nathan');

-- not in clause
select * from employees where first_name not in ('John', 'Mark', 'Jacob');

-- like clause
-- % for matching sequence characters, _ for matching single character
-- contains 'Mar'
select * from employees where first_name like '%Mar%';
-- starts with 'Mar'
select * from employees where first_name like 'Mar%';
-- ending with 'Mar'
select * from employees where first_name like '%Mar';
-- starts with 'Mar'
select * from employees where first_name like 'Mar%';
-- start with with 'Mar' and 4 characters
select * from employees where first_name like 'Mar_';
-- hired in year 2000
select * from employees where hire_date like '%2000%';
-- employee number starts with '1000` and 5 characters
select * from employees where emp_no like '1000_';

-- not like
select * from employees where first_name not like '%Mar%';

-- Date queries
-- Change the time zone
set global time_zone = "+05:30"; set time_zone = "+05:30"; set @@session.time_zone = "+05:30";

-- Current Date
SELECT CURDATE();

-- Current Date Time
SELECT SYSDATE();
SELECT DATE_FORMAT(SYSDATE(), '%y-%m-%d') AS today;

-- between.. and..
select * from employees where hire_date between '1990-01-01' and '2020-12-31'; -- YYYY-MM-DD
select * from salaries where salary between 66000 and 70000;
select * from departments where dept_no between 'd003' and 'd006';

-- not between.. and..
select * from employees where emp_no not between 10004 and 10012;

-- not null
select * from employees where last_name is not null;
select * from departments where dept_no is not null;

-- null
select * from employees where first_name is null;

-- not equal <> or !=
select * from employees where first_name <> 'mark';
select * from employees where first_name != 'mark'; -- same as above query

-- greater than
select * from employees where hire_date > '2000-01-01'; -- YYYY-MM-DD

-- all female employee hired in year 2000 or after
select * from employees where gender = 'F' and hire_date > '2000-01-01';

-- less than
select * from employees where hire_date < '1985-02-01'; -- YYYY-MM-DD

-- greater than or equal
select * from employees where hire_date >= '2000-01-01'; -- YYYY-MM-DD

-- distinct
-- find distinct hire date
select distinct hire_date from employees;
-- find distinct gender
select distinct gender from employees;

-- order by
select * from employees order by first_name; -- default is ascending order
select * from employees order by first_name asc; -- ascending order. same as above
select * from employees order by first_name desc; -- descending order. same as above
select * from employees order by emp_no desc;
select * from employees order by first_name, last_name; -- ascending order by first_name, last_name
select * from employees order by first_name asc, last_name desc; -- asending order by first_name, descending order by last_name
select * from employees order by hire_date desc;

-- group by
-- must be placed immediately after where conditions if any and just before the order by clause
-- syntax
-- select column_name(s) from table_name where conditions group by column_name(s) order by column_name(s);
select first_name, last_name from employees group by first_name;
select first_name from employees group by first_name;
select first_name from employees group by first_name order by first_name desc;
select first_name, count(*) as names_count from employees group by first_name  order by names_count desc;
-- some versions of MySql to include column in SELECT which are not part of GROUP BY
select first_name, last_name, count(*) as names_count from employees group by first_name  order by names_count desc;
select salary, count(*) emps_with_same_salary from salaries where salary > 80000 group by salary order by salary asc;

-- having clause
-- implemented with group by because it refines output from records that do not satify certain condition
-- syntax
-- select column_name(s) from table_name where conditions group by column_name(s) having conditions order by column_name(s);
-- having is where condition applied to group by clause
-- having can have condition with aggregate functions
-- we cannot have aggregate and non-aggregate condition in having clause
-- find employees with all first_names appeared greater that 250 times
select first_name, count(*) names_count from employees group by first_name having count(*) > 250 order by names_count;
select *, avg(salary) average_salary from salaries group by emp_no having average_salary > 120000 order by emp_no desc;

-- list of all names that are encountered less than 200 times. Data refer to people hider after 1st January 1999
select first_name, count(*) names_count from employees where hire_date > '1999-01-01' group by first_name having names_count < 200 order by names_count desc;

-- Select the employee numbers of all individuals who have signed more than 1 contract after the 1st of January 2000
select emp_no, count(from_date) from dept_emp where from_date > '2000-01-01' group by emp_no having count(from_date) > 1 order by emp_no;

-- limit
select * from employees limit 100;
select * from employees order by first_name desc limit 50;

-- multiple table columns that are not included in the GROUP BY clause will be listed in the SELECT statement. some versions of MySQL may not allow such queries, or at least not by default
-- To adjust the relevant default settings, there is a system variable, called ‘sql_mode’, which needs to be reconfigured
-- to view the current value of this variable in your case, you have to execute the following command
select @@global.sql_mode;
-- An expression containing a few values, separated by commas, will appear in the result grid. They correspond to various MySQL settings that influence the way in which MySQL will behave in different situations
-- One of these values, ‘only_full_group_by’, blocks certain type of group statements and that can potentially lead to Error Code 1055. The latter signifies the problem of listing fields in the SELECT statement that are not included in the GROUP BY clause
-- to prevent it from happening, we must execute the following statement
set @@global.sql_mode := replace(@@global.sql_mode, 'ONLY_FULL_GROUP_BY', '');
set @@global.sql_mode := concat('ONLY_FULL_GROUP_BY,', @@global.sql_mode);

-- union

-- union all