-- start listener
lsnrctl start

-- check listener stats
lsnrctl status

-- all_tables
select * from all_tables;
select * from all_tables where upper(owner) = 'PRACTICE';

-- dba_tables
select * from dba_tables;
select distinct owner from dba_tables order by owner asc;
select * from dba_tables where upper(owner) = upper('practice');