create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users(username, password, enabled) VALUES('user1', '{noop}12345');
INSERT INTO users(username, password, enabled) VALUES('user2', '{bcrypt}$2a$12$Oxfjl53Ch6eZrQRK5ZCTTe.uTrbsXOoGPumEYlQWzi2wTADpzlkTG');

INSERT INTO authorities(username, authority) VALUES ('user1', 'read');
INSERT INTO authorities(username, authority) VALUES ('user2', 'admin');