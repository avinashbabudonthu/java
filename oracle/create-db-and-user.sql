Connect with "/ as sysdba"
alter session set "_ORACLE_SCRIPT"=true;
create user practice identified by practice;
grant resource, connect to practice;
ALTER USER practice quota unlimited on USERS;