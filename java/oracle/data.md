## Update Queries
* Copy data from one column to another column for each row
```
create table table_1
(
    id number primary key,
    column_1 varchar2(50)
);

drop table table_1;

insert into table_1(id, column_1) values (1, 'a'); 
insert into table_1(id, column_1) values (2, 'b');
insert into table_1(id, column_1) values (3, 'c');
insert into table_1(id, column_1) values (4, 'd');
insert into table_1(id, column_1) values (5, 'e');
commit;

alter table table_1 add column_2 varchar2(50);

select * from table_1;
update table_1 set column_2 = column_1;
commit;
```