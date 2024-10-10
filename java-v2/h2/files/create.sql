-- insert record with random uuid and date
insert into employee (id, name, joining_date) values (random_uuid(), 'a', current_date());