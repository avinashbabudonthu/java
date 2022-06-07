use practice;

insert into users(username, password, raw_password, enabled) values ('admin', '$2a$10$1EpwTe/coREJzYYm8hG.aO3F2BEm0cGf3IcNn7xGvGIx0xibQe9Fe', 'admin', true);
insert into users(username, password, raw_password, enabled) values ('user1', '$2a$10$BZv5JH5PCnn.d6nqfYvfce./qJZrGpBYx301QbM0G9MydnmngKyz2', 'user1', true);
commit;

insert into t_role (id, role, description) values (uuid(), 'ROLE_ADMIN', 'Admin user');
insert into t_role (id, role, description) values (uuid(), 'ROLE_USER', 'Normal user');
commit;

insert into authorities(id, username, role_id) values (uuid(), (select username from users where username='admin'),(select id from t_role where role like 'ROLE_ADMIN'));
insert into authorities(id, username, role_id) values (uuid(), (select username from users where username='user1'),(select id from t_role where role like 'ROLE_USER'));
commit;

insert into t_role_page(id, role_id, page_name) values (uuid(), (select id from t_role where role = 'ROLE_ADMIN'), 'page1');
insert into t_role_page(id, role_id, page_name) values (uuid(), (select id from t_role where role = 'ROLE_ADMIN'), 'page2');
insert into t_role_page(id, role_id, page_name) values (uuid(), (select id from t_role where role = 'ROLE_ADMIN'), 'page3');

insert into t_role_page(id, role_id, page_name) values (uuid(), (select id from t_role where role = 'ROLE_USER'), 'page1');
insert into t_role_page(id, role_id, page_name) values (uuid(), (select id from t_role where role = 'ROLE_USER'), 'page3');
commit;