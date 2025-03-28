CREATE TABLE DEPT
(
 DEPTNO NUMBER(32)
,DNAME VARCHAR2(50)
,LOC VARCHAR2(50)
,CONSTRAINT DEPTNO_PK PRIMARY KEY(DEPTNO)
);

CREATE TABLE EMP
(
 EMPNO NUMBER(32)
,ENAME VARCHAR2(50)
,DEPTNO NUMBER(32) CONSTRAINT DEPTNO_FK REFERENCES DEPT(DEPTNO) ON DELETE CASCADE
,JOB VARCHAR2(50)
,SAL NUMBER(32)
,COMM NUMBER(32)
,MGR NUMBER(32) CONSTRAINT MGR_FK REFERENCES EMP(EMPNO)
,HIREDATE DATE
,ACTIVE BOOLEAN
,CONSTRAINT EMPNO_PK PRIMARY KEY(EMPNO)
);

CREATE TABLE SALGRADE
(
 HISAL NUMBER(32)
,LOSAL NUMBER(32)
,GRADE NUMBER(32)
);

INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(20,'RESEARCH','DALLAS');
INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(30,'SALES','CHICAGO');
INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(40,'OPERATIONS','BOSTON');
COMMIT;

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981', 'dd-MM-yyyy'),5000,NULL,10);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981', 'dd-MM-yyyy'),2850,NULL,30);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981', 'dd-MM-yyyy'),2450,NULL,10);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981', 'dd-MM-yyyy'),2975,NULL,20);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981', 'dd-MM-yyyy'),1250,1400,30);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981', 'dd-MM-yyyy'),1600,300,30);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981', 'dd-MM-yyyy'),1500,0,30);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981', 'dd-MM-yyyy'),950,NULL,30);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981', 'dd-MM-yyyy'),1250,500,30);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7902,'FORD','ANALYST',7566,parsedatetime('03-12-1981', 'dd-MM-yyyy'),3000,NULL,20);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980', 'dd-MM-yyyy'),800,NULL,20);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7788,'SCOTT','ANALYST',7566,parsedatetime('09-12-1982', 'dd-MM-yyyy'),3000,NULL,20);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7876,'ADAMS','CLERK',7788,parsedatetime('12-01-1983', 'dd-MM-yyyy'),1100,NULL,20);
INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES (7934,'MILLER','CLERK',7782,parsedatetime('23-01-1982', 'dd-MM-yyyy'),1300,NULL,10);
COMMIT;

INSERT INTO SALGRADE (HISAL, LOSAL, GRADE) VALUES (1, 700, 1200);
INSERT INTO SALGRADE (HISAL, LOSAL, GRADE) VALUES (2, 1201, 1400);
INSERT INTO SALGRADE (HISAL, LOSAL, GRADE) VALUES (3, 1401, 2000);
INSERT INTO SALGRADE (HISAL, LOSAL, GRADE) VALUES (4, 2001, 3000);
INSERT INTO SALGRADE (HISAL, LOSAL, GRADE) VALUES (5, 3001, 9999);
COMMIT;