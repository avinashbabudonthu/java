### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Practice Tables and data
* dept table
```
create table dept
(
 deptno int(32)
,dname varchar(50)
,loc varchar(50)
,constraint deptno_pk primary key(deptno)
);
```
* emp table
```
create table emp
(
 empno int(32)
,ename varchar(50)
,deptno int(32)
,job varchar(50)
,sal int(32)
,comm int(32)
,mgr int(32)
,hiredate date
,active boolean
,constraint empno_pk primary key(empno),
constraint deptno_fk foreign key (deptno) references dept(deptno) on delete cascade,
constraint mgr_fk foreign key (mgr) references emp(empno)
);
```
* salgrade table
```
create table salgrade
(
 hisal int(32)
,losal int(32)
,grade int(32)
);
```
* Inserts
```
insert into dept(deptno, dname, loc) values(10,'accounting','new york');
insert into dept(deptno, dname, loc) values(20,'research','dallas');
insert into dept(deptno, dname, loc) values(30,'sales','chicago');
insert into dept(deptno, dname, loc) values(40,'operations','boston');
commit;

insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7839,'king','president',null,'1981-11-17',5000,null,10);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7698,'blake','manager',7839,'1981-05-01',2850,null,30);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7782,'clark','manager',7839,'1981-06-09',2450,null,10);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7566,'jones','manager',7839,'1981-02-04',2975,null,20);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7654,'martin','salesman',7698,'1981-09-28',1250,1400,30);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7499,'allen','salesman',7698,'1981-02-20',1600,300,30);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7844,'turner','salesman',7698,'1981-09-08',1500,0,30);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7900,'james','clerk',7698,'1981-12-03',950,null,30);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7521,'ward','salesman',7698,'1981-02-22',1250,500,30);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7902,'ford','analyst',7566,'1981-12-03',3000,null,20);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7369,'smith','clerk',7902,'1980-12-17',800,null,20);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7788,'scott','analyst',7566,'1982-12-09',3000,null,20);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7876,'adams','clerk',7788,'1983-01-12',1100,null,20);
insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (7934,'miller','clerk',7782,'1982-01-23',1300,null,10);
commit;

insert into salgrade (hisal, losal, grade) values (1, 700, 1200);
insert into salgrade (hisal, losal, grade) values (2, 1201, 1400);
insert into salgrade (hisal, losal, grade) values (3, 1401, 2000);
insert into salgrade (hisal, losal, grade) values (4, 2001, 3000);
insert into salgrade (hisal, losal, grade) values (5, 3001, 9999);
commit;
```
* Selects
```
select * from emp;
select * from dept;
select * from salgrade;
select count(*) from emp;
select count(*) from dept;
select count(*) from salgrade;
select * from emp e join dept d on e.deptno = d.deptno;
```
* Delete data
```
delete from salgrade;
delete from emp;
delete from dept;
commit;
```
* Drop tables
```
drop table dept;
drop table emp;
drop table salgrade;
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)