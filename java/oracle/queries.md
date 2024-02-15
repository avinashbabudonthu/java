## Select Queries
* select all records from table employee
```
select * from employee;
```
* Select User
```
SELECT USER FROM DUAL;
```
* Save current session sql commands to file. File will be saved on running `SPOOL OFF`
```
SPOOL [path]\[fileName].extension
```


## Case Statements
* Case in Select Query
```
DROP TABLE JOB IF EXISTS;

CREATE TABLE JOB (JOB_CD VARCHAR(10) PRIMARY KEY, JOB_DESC VARCHAR(20));

DROP TABLE EMPLOYEE IF EXISTS;

CREATE TABLE EMPLOYEE (ID NUMBER, NAME VARCHAR(20), JOB_CD VARCHAR(10));

INSERT INTO JOB VALUES ('HR', 'HR DEPARTMENT');

INSERT INTO EMPLOYEE VALUES (1, 'JACK', 'HR');
INSERT INTO EMPLOYEE VALUES (1, 'JACK', 'AB');

COMMIT;

SELECT 
CASE  
 WHEN (SELECT JOB_DESC FROM JOB WHERE JOB_CD = E.JOB_CD) IS NOT NULL THEN (SELECT JOB_DESC FROM JOB WHERE JOB_CD = E.JOB_CD)
 ELSE E.JOB_CD 
END
AS JOB_CD FROM EMPLOYEE E;
```
![picture](images/case-query-output.jpg)

## Date Queries
* Add 30 seconds to current date
```
select sysdate NOW, sysdate+30/(24*60*60) NOW_PLUS_30_SECS from dual;
```
* Convert 24 Hour time to 12 Hour plus AM/PM indication Oracle SQL
```
SELECT invoice_date,
 TO_CHAR(invoice_date, 'DD-MM-YYYY HH24:MI:SS') "Date 24Hr",
 TO_CHAR(invoice_date, 'DD-MM-YYYY HH:MI:SS AM') "Date 12Hr"
FROM invoices;
```
* Check the date is future date or not
```
SELECT APPT_BEG_DATETIME, TO_DATE(CURRENT_DATE, 'DD-MON-YY HH24:MI:SS') AS TODAY,
CASE 
	WHEN TO_DATE(APPT_BEG_DATETIME, 'DD-MON-YY HH24:MI:SS') > TO_DATE(CURRENT_DATE, 'DD-MON-YY HH24:MI:SS') THEN 'YES' ELSE 'NO' 
END AS IS_FUTURE
FROM SH_APPOINTMENTS;
```
* Group by create date
```
select count(*), to_char(create_date,  'DD-MON-YY') from MY_TABLE group by to_char(create_date,  'DD-MON-YY');
```
* Group by create date and descending order of date
```
select count(*), to_date(create_date,  'DD-MON-YY') from MY_TABLE group by to_date(create_date,  'DD-MON-YY') order by to_date(create_date,  'DD-MON-YY') desc;
```
------
# Date between
* Oracle SQL provides several ways to query dates within a specific range. Here are the most common approaches:
1. BETWEEN operator:
* This is the most straightforward way to query dates between two specific dates:
```
SQL
SELECT * FROM your_table
WHERE your_date_column BETWEEN start_date AND end_date;
```
2. `>=` and `<` operators:
* This approach is more explicit and avoids potential confusion with time components:
```
SQL
SELECT * FROM your_table
WHERE your_date_column >= start_date
AND your_date_column < end_date;
```
3. TRUNC function:
* If you only care about the date portion and not the time, you can use the TRUNC function to truncate both dates to the beginning of the day:
```
SQL
SELECT * FROM your_table
WHERE TRUNC(your_date_column, 'DAY') >= TRUNC(start_date, 'DAY')
AND TRUNC(your_date_column, 'DAY') < TRUNC(end_date, 'DAY');
```
4. TO_DATE function:
* If your dates are stored as strings, you need to convert them to the DATE data type before using any of the above methods:
```
SQL
SELECT * FROM your_table
WHERE your_date_column >= TO_DATE('2024-02-01', 'YYYY-MM-DD')
AND your_date_column < TO_DATE('2024-02-15', 'YYYY-MM-DD');
```
* Remember to replace your_table and your_date_column with the actual names in your schema.
* Adjust the date formats in the TO_DATE function according to your actual data format.
* Consider using bind variables instead of hardcoding dates in your queries for better security and performance.
* If you're dealing with timestamps (including time components), you might need to adjust the queries accordingly.

------