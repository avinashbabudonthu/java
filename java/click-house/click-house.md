# Materials in study order
* https://clickhouse.com/docs/en/intro
------
# Quick start
* https://clickhouse.com/docs/en/getting-started/quick-start
# Create a table
* Use CREATE TABLE to define a new table. Typical SQL DDL commands work in ClickHouse with one addition - tables in ClickHouse require an ENGINE clause. Use MergeTree to take advantage of the performance benefits of ClickHouse:
```
CREATE TABLE my_first_table
(
    user_id UInt32,
    message String,
    timestamp DateTime,
    metric Float32
)
ENGINE = MergeTree
PRIMARY KEY (user_id, timestamp)
```

# Insert data
You can use the familiar INSERT INTO TABLE command with ClickHouse, but it is important to understand that each insert into a MergeTree table causes a part (folder) to be created in storage. To minimize parts, bulk insert lots of rows at a time (tens of thousands or even millions at once).
```
INSERT INTO my_first_table (user_id, message, timestamp, metric) VALUES
    (101, 'Hello, ClickHouse!',                                 now(),       -1.0    ),
    (102, 'Insert a lot of rows per batch',                     yesterday(), 1.41421 ),
    (102, 'Sort your data based on your commonly-used queries', today(),     2.718   ),
    (101, 'Granules are the smallest chunks of data read',      now() + 5,   3.14159 )
```

#Query your new table
You can write a SELECT query just like you would with any SQL database:
```
SELECT *
FROM my_first_table
ORDER BY timestamp
```
------
# Java Language Client Options for ClickHouse
* https://clickhouse.com/docs/en/integrations/java