-- select all records from table
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
select * from MY_TABLE;
select * from "MY_TABLE_2022-12-16";

-- Describe
select column_name from information_schema.columns where table_name = 'emp';

-- PostgreSQL - Date Difference in Years:
-- Difference between Oct 02, 2011 and Jan 01, 2012 in years
SELECT DATE_PART('year', '2012-01-01'::date) - DATE_PART('year', '2011-10-02'::date);
-- Result: 1

-- PostgreSQL - Date Difference in Months:
-- Difference between Oct 02, 2011 and Jan 01, 2012 in months
SELECT (DATE_PART('year', '2012-01-01'::date) - DATE_PART('year', '2011-10-02'::date)) * 12 +
            (DATE_PART('month', '2012-01-01'::date) - DATE_PART('month', '2011-10-02'::date));
-- Result: 3

-- PostgreSQL - Date Difference in Days:
-- Difference between Dec 29, 2011 23:00 and Dec 31, 2011 01:00 in days
  SELECT DATE_PART('day', '2011-12-31 01:00:00'::timestamp - '2011-12-29 23:00:00'::timestamp);
  -- Result: 1

-- PostgreSQL - Date Difference in Weeks:
-- Difference between Dec 22, 2011 and Dec 31, 2011 in weeks
SELECT TRUNC(DATE_PART('day', '2011-12-31'::timestamp - '2011-12-22'::timestamp)/7);
-- Result: 1

-- PostgreSQL - Datetime Difference in Hours:
-- Difference between Dec 30, 2011 08:55 and Dec 30, 2011 9:05 in weeks
SELECT DATE_PART('day', '2011-12-30 08:55'::timestamp - '2011-12-30 09:05'::timestamp) * 24 + 
          DATE_PART('hour', '2011-12-30 08:55'::timestamp - '2011-12-30 09:05'::timestamp);
-- Result: 0

-- PostgreSQL - Datetime Difference in Minutes:
-- Difference between Dec 30, 2011 08:54:55 and  Dec 30, 2011 08:56:10 in minutes
SELECT (DATE_PART('day', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp) * 24 + 
           DATE_PART('hour', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp)) * 60 +
           DATE_PART('minute', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp);
-- Result: 1
 
-- Time only
SELECT DATE_PART('hour', '08:56:10'::time - '08:54:55'::time) * 60 +
            DATE_PART('minute', '08:56:10'::time - '08:54:55'::time);
-- Result: 1

-- PostgreSQL - Datetime Difference in Seconds:
-- Difference between Dec 30, 2011 08:54:55 and  Dec 30, 2011 08:56:10 in seconds
SELECT ((DATE_PART('day', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp) * 24 + 
            DATE_PART('hour', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp)) * 60 +
            DATE_PART('minute', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp)) * 60 +
            DATE_PART('second', '2011-12-30 08:56:10'::timestamp - '2011-12-30 08:54:55'::timestamp);
-- Result: 75
 
-- Time only
SELECT (DATE_PART('hour', '08:56:10'::time - '08:54:55'::time) * 60 +
             DATE_PART('minute', '08:56:10'::time - '08:54:55'::time)) * 60 +
             DATE_PART('second', '08:56:10'::time - '08:54:55'::time);
-- Result: 75

-- current date
select current_date;

-- current date with timestamp
select current_timestamp;

-- current date in YYYY_MM_DD format
SELECT TO_CHAR(CURRENT_TIMESTAMP, 'YYYY_MM_DD');

-- count number of partitions on table - tab
SELECT count(*) AS partitions FROM pg_catalog.pg_inherits WHERE inhparent = 'tab'::regclass;
SELECT * FROM pg_catalog.pg_inherits WHERE inhparent = 'tab'::regclass;

-- partition details
select * from pg_class where relispartition is true;
select * from pg_class where relispartition is FALSE;

-- partitions of table - tab
SELECT * FROM PG_CLASS WHERE RELNAME LIKE 'tab%';