-- Create index
-- CREATE INDEX [index name] ON [Table name]; 
CREATE INDEX my-index ON employees (first_name, email, phone_number);

-- drop index
-- DROP INDEX [index name]
DROP INDEX my-index;