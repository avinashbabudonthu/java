-- use employees database
use employees;

SELECT emp_no, first_name, last_name, CASE WHEN gender = 'M' THEN 'Male' ELSE 'Female' END AS gender FROM employees;
SELECT emp_no, first_name, last_name, CASE gender WHEN 'M' THEN 'Male' ELSE 'Female' END AS gender FROM employees; # this will not work in all scenarios
