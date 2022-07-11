-- use employees database
use employees;

set @v_avg_salary = 0;

-- find maximum number of connections allowed
select @@global.max_connections;