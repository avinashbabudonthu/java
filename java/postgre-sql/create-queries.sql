-- create table with partition
CREATE TABLE MY_TAB (
   ID bigint GENERATED ALWAYS AS IDENTITY,
   CREATE_DATE timestamp NOT NULL,
   DATA text
) PARTITION BY LIST ((CREATE_DATE::DATE));
 
CREATE TABLE MY_TAB_DEF PARTITION OF MY_TAB DEFAULT;