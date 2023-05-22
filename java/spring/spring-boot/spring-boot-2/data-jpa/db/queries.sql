use practice;
show tables;

-- emp
select * from emp;
select count(*) from emp;

-- student
select * from student;
insert into student(name,course,joining_date) VALUES('jack', 'java', (select sysdate()));
insert into student(name,course,joining_date) VALUES('jill', 'spring', (select sysdate()));
insert into student(name,course,joining_date) VALUES('james', 'maven', (select sysdate()));
delete from student;
drop table student;
commit;