-- create data base scripts
create database if not exists practice;
show databases;
create user 'admin'@'localhost' identified by 'admin';
grant all on my_sql_practice.* to 'admin'@'localhost';

use my_sql_practice;