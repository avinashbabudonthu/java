create database practice_db as perm=3048576000;

grant all on syslib to practice_db, dbc with grant option;
grant execute function on syslib to practice_db, dbc with grant option;
grant select on sysudtlib to practice_db with grant option;
grant all on dbc to dbc with grant option;
grant all on syslib to dbc with grant option;
grant all on sysudtlib to dbc with grant option;
grant all on dbc to practice_db with grant option;
grant select on dbc to public;
grant select on practice_db to public;
grant all on practice_db to dbc with grant option;
grant select on udtinfo to practice_db, dbc with grant option;
grant select on dbc.udtinfo to practice_db;

create table practice_db.emp(
	empno integer
) unique primary index(empno);

select * from practice_db.emp;
show table practice_db.emp;
