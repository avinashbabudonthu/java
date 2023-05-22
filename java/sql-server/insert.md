# Insert
```
insert into person (id, name, address) values (3, 'jim', 'US');
```

# Insert into new table by select on another table
```
create table person2(
	id int,
	name varchar(50),
	address varchar(100)
);

insert into person2 (id, name, address) select id, name, address from person;
```