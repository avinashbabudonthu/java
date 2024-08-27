-- Update field value in JSON column
-- student table record - `id`, `details`
1, {"enabled": "true", "name": "a", "course": "java"}
-- Update query
update student set details = jsonb_set(details, '{enabled}', 'false') where id = 1;
-----------------------------
