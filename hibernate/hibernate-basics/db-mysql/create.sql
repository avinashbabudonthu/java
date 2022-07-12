use my_sql_practice;

create table student
(
	id bigint auto_increment,
    name varchar(50),
    course_name varchar(50),
    course_start_date datetime,
    primary key(id)
);