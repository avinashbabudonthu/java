-- use employees database
use employees;

select * from departments_dup;
-- updates all records becuase no where clause
update departments_dup set dept_no = 'd010', dept_name = 'test department';
rollback;

-- Change the “Business Analysis” department name to “Data Analysis”
select * from departments;
update departments set dept_name = 'Data Analysis' where dept_no = 'd010';
commit;