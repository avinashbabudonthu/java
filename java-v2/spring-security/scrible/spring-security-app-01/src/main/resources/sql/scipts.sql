-- Tables suggested by spring security
create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users(username, password, enabled) VALUES('user1', '{noop}12345');
INSERT INTO users(username, password, enabled) VALUES('user2', '{bcrypt}$2a$12$Oxfjl53Ch6eZrQRK5ZCTTe.uTrbsXOoGPumEYlQWzi2wTADpzlkTG');

INSERT INTO authorities(username, authority) VALUES ('user1', 'read');
INSERT INTO authorities(username, authority) VALUES ('user2', 'admin');

------
-- Our custom tables instead of spring security tables
CREATE TABLE customer
(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO customer(email, pwd, role) VALUES ('user1@example.com', '{noop}123456', 'read');

-- pwd - Bcrypt encrypted of - Password@17072024
INSERT INTO customer(email, pwd, role) VALUES ('user2@example.com', '{bcrypt}$2a$12$qPtcE19OirGPyg7o7xhZaOwgIoVYT5KO6FGtSNQrLfN5CLltKd1lC', 'admin');