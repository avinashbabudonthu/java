DROP TRIGGER IF EXISTS part_trig ON TAB;
DROP FUNCTION IF EXISTS part_trig();
DROP TABLE IF EXISTS TAB_DEF;
DROP TABLE IF EXISTS "tab_2022-12-16";
DROP TABLE IF EXISTS "tab_2022_12_16";
DROP TABLE IF EXISTS TAB;

CREATE TABLE TAB (
   id bigint GENERATED ALWAYS AS IDENTITY,
   ts timestamp NOT NULL,
   data text
) PARTITION BY LIST ((ts::date));
 
CREATE TABLE TAB_DEF PARTITION OF TAB DEFAULT;

CREATE FUNCTION part_trig() RETURNS trigger
   LANGUAGE plpgsql AS
$$BEGIN
   BEGIN
      /* try to create a table for the new partition */
      EXECUTE
         format(
            'CREATE TABLE %I (LIKE tab INCLUDING INDEXES)',
            'tab_' || to_char(NEW.ts, 'YYYY_MM_DD')
         );
 
      /*
       * tell listener to attach the partition
       * (only if a new table was created)
       */
      EXECUTE
         format(
            'NOTIFY tab, %L',
            to_char(NEW.ts, 'YYYY_MM_DD')
         );
   EXCEPTION
      WHEN duplicate_table THEN
         NULL;  -- ignore
   END;
 
   /* insert into the new partition */
   EXECUTE
      format(
         'INSERT INTO %I VALUES ($1.*)',
         'tab_' || to_char(NEW.ts, 'YYYY_MM_DD')
      )
      USING NEW;
 
   /* skip insert into the partitioned table */
   RETURN NULL;
END;$$;
 
CREATE TRIGGER part_trig
   BEFORE INSERT ON TAB FOR EACH ROW
   WHEN (pg_trigger_depth() < 1)
   EXECUTE FUNCTION part_trig();

insert into tab (ts, data) values (current_timestamp, 'one');
insert into tab (ts, data) values (current_timestamp, 'two');
insert into tab (ts, data) values (current_timestamp, 'three');
insert into tab (ts, data) values (current_timestamp, 'four');
insert into tab (ts, data) values (current_timestamp, 'five');

select current_date;
select current_timestamp;
SELECT TO_CHAR(CURRENT_TIMESTAMP, 'YYYY_MM_DD');
SELECT count(*) AS partitions FROM pg_catalog.pg_inherits WHERE inhparent = 'tab'::regclass;
SELECT * FROM pg_catalog.pg_inherits WHERE inhparent = 'tab'::regclass;
select * from pg_class where relispartition is true;
select * from pg_class where relispartition is FALSE;
SELECT * FROM PG_CLASS WHERE RELNAME LIKE 'tab%';

select * from tab;
SELECT * FROM TAB_DEF;
select * from tab_2022_12_16;
select * from "tab_2022-12-16";