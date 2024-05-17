* Create database
```
CREATE DATABASE "001-practice"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "001-practice"
    IS 'Postgres practice database';
```